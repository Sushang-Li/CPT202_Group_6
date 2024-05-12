package com.group6.booking4sportcentre.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group6.booking4sportcentre.mapper.CoachInfoMapper;
import com.group6.booking4sportcentre.mapper.SportActivityMapper;
import com.group6.booking4sportcentre.model.CoachInfo;
import com.group6.booking4sportcentre.model.SportActivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Slf4j
/*@CrossOrigin(origins="*")*/
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})


@RestController
@RequestMapping("/api/sportActivity")
public class SportActivityController {
    @Autowired
    private SportActivityMapper sportActivityMapper;
    @Autowired
    private CoachInfoMapper coachMapper;
    //得到目前所有的体育活动
    //注意：得到的应该是空闲的所有的体育活动,目前还是所有的体育活动
    //每个项目预定也是先调用这个接口
    //测试成功，接口等待更改
    @GetMapping("/allActivities")
    public List<SportActivity> getAllSportActivities() {
        List<SportActivity> list = sportActivityMapper.selectList(null);
        return list;
    }

    //更新票数,只是更新，数据在前端完成了更改传递到了后端
    @PostMapping("/updateTicketNumber")
    public void updateTicketNumber(@RequestParam int id, @RequestParam int current, @RequestParam int price) {
        SportActivity sportActivity = new SportActivity();
        sportActivity.setId(id);
        sportActivity.setTicketNumber(current);
        sportActivity.setPrice(price);

        sportActivityMapper.updateById(sportActivity);
    }
    //从booking的信息直接更新activity
    @GetMapping("/updateOneActivity")
    public void updateOneActivity(@RequestParam String actName, @RequestParam LocalDate date,
                                  @RequestParam LocalTime startTime, @RequestParam LocalTime endTime,
                                  @RequestParam String stadium) {
        QueryWrapper<SportActivity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", actName);
        queryWrapper.eq("date", date);
        queryWrapper.eq("start_time", startTime);
        queryWrapper.eq("end_time", endTime);
        queryWrapper.eq("stadium", stadium);

        SportActivity sportActivity = sportActivityMapper.selectOne(queryWrapper);


        int temp = sportActivity.getTicketNumber();
        sportActivity.setTicketNumber(temp + 1);

        sportActivityMapper.update(sportActivity);



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
       CoachInfo coach = coachMapper.selectOne(new QueryWrapper<CoachInfo>().eq("name", sportActivity.getCoach()));
       System.out.println("名字是1："+coach.getName());
       if (coach != null ) {
           // 设置要更新的体育活动的 ID
           sportActivity.setId(id);
           // 调用 Mapper 接口中的更新方法
           int rowsAffected = sportActivityMapper.update(sportActivity);

           if (rowsAffected > 0) {
               return "Sport activity updated successfully";
           } else {
               return "Failed to update sport activity";
           }
       } else {
           return "Failed to add sport activity due to the coach is not exist. Please check again.";
       }
    }


    @PostMapping("/add")
    public String add(@RequestBody SportActivity sportActivity){
        CoachInfo coach = coachMapper.selectOne(new QueryWrapper<CoachInfo>().eq("name", sportActivity.getCoach()));
        System.out.println("名字是1："+coach.getName());
        if (coach != null ) {
            int i = sportActivityMapper.add(sportActivity);
            if (i == 0) {
                return "Failed to add sport activity";
            }
            return "Sport activity added successfully";
        } else {
            return "Failed to add sport activity due to the coach is not exist. Please check again.";
        }
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
