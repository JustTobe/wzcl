package com.kcsj.wzcl.service.serviceImple;

import com.kcsj.wzcl.bean.*;
import com.kcsj.wzcl.mapper.OperationMapper;
import com.kcsj.wzcl.mapper.VehicleMapper;
import com.kcsj.wzcl.mapper.ViolationMapper;
import com.kcsj.wzcl.utils.Result;
import com.kcsj.wzcl.utils.EmailSender;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//import sun.security.mscapi.RSASignature;
import sun.security.provider.MD5;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ViolationService {
    @Autowired
    private ViolationMapper violationMapper;
    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private OperationMapper operationMapper;


    //图片存储路径
    private static String path="C:\\server\\pic";

    public Result upload(MultipartFile file)
    {
        //存储文件名
        String fileName=System.currentTimeMillis()+file.getOriginalFilename();

        File picPath=new File(path+File.separator+fileName);

        try{
            file.transferTo(picPath);

        }catch(IOException e)
        {
            e.printStackTrace();
            return Result.Fail();
        }

        Result result =new Result();
        result.setStatusCode(200);
        result.setData(fileName);
        return result;
    }

    public byte[] showPic(String name) {
        //File picPath=new File(path+File.separator+pic);
        try {
            File file=new File(path+File.separator+name+".jpg");
            System.out.println(name);
            FileInputStream fis=new FileInputStream(file);
            System.out.println(file==null);
            byte[] bytes=new byte[fis.available()];
            fis.read(bytes,0,fis.available());
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Result add(Violation violation)
    {
        if(violationMapper.insert(violation)==0)
            return Result.Fail();
        return Result.Success();
    }

    public Result getHistory(String plate)
    {
        ViolationExample ve=new ViolationExample();
        ve.or().andPlateEqualTo(plate);
        List<Violation> violations=violationMapper.selectByExample(ve);
        if(violations.isEmpty())
            return Result.Fail();
        return Result.add(violations);
    }

    public Result putStatus(Violation vio)
    {
        int id=vio.getId();
        System.out.println(id);
        ViolationExample ve=new ViolationExample();
        ve.or().andIdEqualTo(id);

        if(violationMapper.updateByExample(vio,ve)==0)
            return Result.Fail();

        if(vio.getStatus().equals("最终确认"))
        {


            int grade=2;//type对应积分

            //获取对应vehicle
            VehicleExample ve2=new VehicleExample();
            ve2.or().andIdEqualTo(vio.getUserId());
            List<Vehicle> vehicles=vehicleMapper.selectByExample(ve2);
            System.out.println(vehicles.size());
            Vehicle vehicle=vehicles.get(0);
            //更新积分、次数
            vehicle.setGrade(vehicle.getGrade()+grade);
            vehicle.setCount(vehicle.getCount()+1);
            System.out.print(vehicle.getCount()+"\t"+vehicle.getGrade());
            vehicleMapper.updateByExample(vehicle,ve2);

            int count=vehicle.getCount();
            boolean ban=(vehicle.getGrade()<6);

            Message msg=new Message(vehicle.getName(),vehicle.getIdentityType(),
                    null,null,vio.getArea(),vio.getType(),
                    vio.getPlate(),count,ban);

            EmailSender emailSender=new EmailSender();
            //emailSender.sendEmail(vehicle.getEmail(),msg);
        }
        return Result.Success();
    }

    public Result submit(Map<String,Object> map)
    {
        Violation vio=new Violation();
        //Operation ope=new Operation();
        Date date=(Date)map.get("date");
        String area=(String)map.get("area");
        String plate=(String)map.get("plate");
        String platePic=(String)map.get("platePic");
        String vioPic=(String)map.get("vioPic");
        String content=(String)map.get("content");
        int userId=(int)map.get("userId");
        vio.setDate(date);
        vio.setStatus("违章上报");
        vio.setArea(area);
        vio.setPlate(plate);
        vio.setPlatePic(platePic);
        vio.setVioPic(vioPic);
        vio.setUserId(userId);

        //transaction
        int n1=violationMapper.insert(vio);
        //System.out.println(vio.getId());
        int vioId=vio.getId();
        Operation ope=new Operation(0,vioId,"admin",content,null);
        int n2=operationMapper.insert(ope);
        if(n1==0||n2==0)
            return Result.Fail();
        return Result.add(Integer.valueOf(vioId));
    }

    public Result preConfirm(Map<String,Object> map)
    {
        String type=(String)map.get("type");
        String content=(String)map.get("content");
        int vioId=(int)map.get("vioId");
        Operation ope=new Operation(0,vioId,"admin2",content,null);
        //transaction
        Violation violation=violationMapper.selectByPrimaryKey(vioId);
        violation.setType(type);
        violation.setStatus("初步确认");
        violationMapper.updateByPrimaryKey(violation);
        operationMapper.insert(ope);
        return Result.add(Integer.valueOf(vioId));
    }
    public Result finalConfirm(Map<String,Object> map)
    {
        String content=(String)map.get("content");
        int vioId=(int)map.get("vioId");
        int userId=(int)map.get("userId");

        int grade=2;//type对应积分 etc


        //事务
        Operation ope=new Operation(0,vioId,"admin",content,null);
        operationMapper.insert(ope);

        Violation violation=violationMapper.selectByPrimaryKey(vioId);
        violation.setStatus("最终确认");
        violationMapper.updateByPrimaryKey(violation);

        Vehicle vehicle=vehicleMapper.selectByPrimaryKey(userId);
        vehicle.setCount(vehicle.getCount()+1);
        vehicle.setGrade(vehicle.getGrade()+grade);
        vehicleMapper.updateByPrimaryKey(vehicle);
        //发短信
        int count=vehicle.getCount();
        boolean ban=(vehicle.getGrade()<6);

        Message msg=new Message(vehicle.getName(),vehicle.getIdentityType(),
                null,null,violation.getArea(),violation.getType(),
                violation.getPlate(),count,ban);

        EmailSender emailSender=new EmailSender();
        //emailSender.sendEmail(vehicle.getEmail(),msg);
        return Result.Success();
    }

    public Result cancel(Map<String,Object> map)
    {
        String content=(String)map.get("content");
        int vioId=(int)map.get("vioId");
        //事务
        Operation ope=new Operation(0,vioId,"admin",content,null);
        operationMapper.insert(ope);
        Violation violation=violationMapper.selectByPrimaryKey(vioId);
        violation.setStatus("撤销");
        violationMapper.updateByPrimaryKey(violation);
        return Result.Success();
    }
}
