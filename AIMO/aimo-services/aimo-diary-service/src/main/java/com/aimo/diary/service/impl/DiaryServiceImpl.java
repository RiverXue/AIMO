package com.aimo.diary.service.impl;

import com.aimo.diary.entity.Diary;
import com.aimo.diary.mapper.DiaryMapper;
import com.aimo.diary.service.DiaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
// 继承 ServiceImpl 类，实现 DiaryService 接口
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements DiaryService {
}
