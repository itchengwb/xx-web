package com.noriental.velocity.service.impl;

import com.noriental.velocity.service.InfoService;
import com.noriental.velocity.vo.Info;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Discribe:construct Object
 * Project:xx-web
 * Package: com.noriental.service.impl
 * User: Chengwenbo
 * Date:  2015/12/2
 * Time: .15:35
 */
@Service
public class InfoServiceImpl implements InfoService {

    public Info getInfo(){
        Info info = new Info();

        String msg = "Bean msg 测试";

        Map<String,String> map =  new HashMap<String,String>();
        List<Integer> list = new ArrayList<Integer>();

        for(int i=1;i<=5;i++){
            int num  = new Double(Math.random()*100).intValue();
            map.put("K"+i,"V"+num);
            list.add(num);
        }

        info.setMsg(msg);
        info.setMap(map);
        info.setList(list);

        return info;
    }
}
