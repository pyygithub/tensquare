package com.pyy.base.controller;


import com.pyy.base.entity.PageResult;
import com.pyy.base.entity.Result;
import com.pyy.base.entity.StatusCode;
import com.pyy.base.model.Label;
import com.pyy.base.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签控制层
 * @author panyy
 */
@RestController
@RequestMapping("/base/v1/label")
public class LabelController {
    @Autowired
    private LabelService labelService;
    /**
     * 查询全部列表 * @return
     */
    @GetMapping
    public Result<List> findAll(){
        return new Result<>(StatusCode.OK,"查询成功", labelService.findAll() );
    }
    /**
     * 根据ID查询标签 * @param id
     * @return
     */
    @GetMapping(value="/{id}")
    public Result<Label> findById(@PathVariable String id){
        return new Result<>(StatusCode.OK,"查询成功",labelService.findById(id));
    }

    /**
     * 增加标签
     * @param label
     * @return
     */
    @PostMapping
    public Result add( @RequestBody Label label){
        labelService.add(label);
        return new Result(StatusCode.OK,"增加成功");
    }

    /**
     * 修改标签
     * @param label
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update( @RequestBody Label label, @PathVariable String id){
        label.setId(id);
        labelService.update(label);
        return new Result(StatusCode.OK,"修改成功");
    }

    /**
     * 删除标签
     * @param id
     * @return
     */
    @DeleteMapping(value="/{id}")
    public Result deleteById(@PathVariable String id){
        labelService.deleteById(id);
        return new Result(StatusCode.OK,"删除成功");
    }

    /**
     * 标签条件查询
     * @param label
     * @return
     */
    @PostMapping(value="/search")
    public Result search(@RequestBody Label label){
        List<Label> labelList = labelService.search(label);
        return new Result(StatusCode.OK,"查询成功", labelList);
    }

    /**
     * 分页查询
     * @param label
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value="/search/$page")
    public Result search(@RequestBody Label label, @RequestParam int page, @RequestParam int size){
        PageResult<Label> pageResult = labelService.pageQuery(label, page, size);
        return new Result(StatusCode.OK,"查询成功", pageResult);
    }

}