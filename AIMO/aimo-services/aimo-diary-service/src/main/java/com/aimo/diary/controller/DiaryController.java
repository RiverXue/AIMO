package com.aimo.diary.controller;

import com.aimo.diary.entity.Diary;
import com.aimo.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    public String createDiary(@RequestBody Diary diary) {
        diaryService.save(diary);
        return diary.toString() + " 保存成功";
    }

    @GetMapping("/user/{userId}")
    public List<Diary> listByUserId(@PathVariable String userId) {
        return diaryService.lambdaQuery().eq(Diary::getId, userId).list();
    }
}
