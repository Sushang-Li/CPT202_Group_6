package com.group6.booking4sportcentre.controller;

import com.group6.booking4sportcentre.mapper.SportActivityMapper;
import com.group6.booking4sportcentre.model.SportActivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
/*@CrossOrigin(origins="*")*/
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})


@RestController
@RequestMapping("/api/sportActivity")
public class SportActivityController {
    @Autowired
    private SportActivityMapper sportActivityMapper;

    //得到目前所有的体育活动
    //注意：得到的应该是空闲的所有的体育活动,目前还是所有的体育活动
    //每个项目预定也是先调用这个接口
    //测试成功，接口等待更改
    @GetMapping("/allActivities")
    public List<SportActivity> getAllSportActivities() {
        List<SportActivity> list = sportActivityMapper.selectList(null);
        return list;
    }

    //更新票数
    @PostMapping("/updateTicketNumber")
    public void updateTicketNumber(@RequestParam int id, @RequestParam int current, @RequestParam int price) {
        SportActivity sportActivity = new SportActivity();
        sportActivity.setId(id);
        sportActivity.setTicketNumber(current);
        sportActivity.setPrice(price);

        sportActivityMapper.updateById(sportActivity);
    }

    //查看全部体育活动
    @GetMapping
    public List<SportActivity> list(){
        return sportActivityMapper.list();
    }

    //查看特定id的体育活动
    @GetMapping("/getActivity/{id}")
    public List<SportActivity> getById(@PathVariable int id){
        return  sportActivityMapper.getById(id);
    }

   @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody SportActivity sportActivity) {
        // 设置要更新的体育活动的 ID
       sportActivity.setId(id);
        // 调用 Mapper 接口中的更新方法
        int rowsAffected = sportActivityMapper.update(sportActivity);

        if (rowsAffected > 0) {
            return "Sport activity updated successfully";
        } else {
            return "Failed to update sport activity";
        }
    }
    @PostMapping("/add")
    public void add(@RequestBody SportActivity sportActivity){
        log.info("体育活动为"+ sportActivity);
        sportActivityMapper.add(sportActivity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSportActivity(@PathVariable int id) {
        int rowsAffected = sportActivityMapper.delete(id);
        if (rowsAffected > 0) {
            return "Sport activity with ID " + id + " has been deleted successfully.";
        } else {
            return "Failed to delete sport activity with ID " + id + ". Please check the ID.";
        }
    }
}
