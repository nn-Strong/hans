package com.xiaoke.system.controller;

import com.xiaoke.system.entity.BaseEntity;
import com.xiaoke.system.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

import java.io.Serializable;

public abstract class BaseController<T extends BaseEntity, ID extends Serializable> {
    protected final Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private BaseService<T, ID> baseService;

    public BaseController() {
    }

    /*@ApiOperation("保存")
    @PostMapping({"save"})
    public Message save(@RequestBody T t) {
        try {
            return Message.success(this.baseService.save(t));
        } catch (Exception var3) {
            this.logger.error("保存异常：===》 " + var3);
            return Message.exception(var3.getMessage());
        }
    }

    @ApiOperation("批量保存")
    @PostMapping({"saveBatch"})
    public Message saveBatch(@RequestBody List<T> list) {
        try {
            return Message.success(this.baseService.insertBatch(list));
        } catch (Exception var3) {
            this.logger.error("批量保存异常：===》 " + var3);
            return Message.exception(var3.getMessage());
        }
    }

    @ApiOperation("根据id删除")
    @PostMapping({"remove"})
    public Message remove(ID id) {
        try {
            this.baseService.delete(id);
        } catch (Exception var3) {
            this.logger.error("删除异常：===》 " + var3);
            return Message.exception(var3.getMessage());
        }

        return Message.success();
    }

    @ApiOperation("根据ids批量删除")
    @PostMapping({"removeBatch"})
    public Message removeBatch(@RequestBody List<ID> ids) {
        try {
            this.baseService.deleteBatch(ids);
        } catch (Exception var3) {
            this.logger.error("批量删除异常：===》 " + var3);
            return Message.exception(var3.getMessage());
        }

        return Message.success();
    }

    @ApiOperation("修改")
    @PostMapping({"modify"})
    public Message modify(@RequestBody T t) {
        try {
            return Message.success(this.baseService.update(t));
        } catch (Exception var3) {
            this.logger.error("更新异常：===》 " + var3);
            return Message.exception(var3.getMessage());
        }
    }

    @ApiOperation("根据id查询")
    @GetMapping({"getById"})
    public Message getById(ID id) {
        try {
            return Message.success(this.baseService.getObjectByPK(id));
        } catch (Exception var3) {
            this.logger.error("查询详情异常：===》 " + var3);
            return Message.exception(var3.getMessage());
        }
    }

    @ApiOperation("根据条件查询列表-所有")
    @PostMapping({"queryList"})
    public Message queryList(@RequestBody T t) {
        try {
            return Message.success(this.baseService.queryList(t));
        } catch (Exception var3) {
            this.logger.error("查询列表异常：===》 " + var3);
            return Message.exception(var3.getMessage());
        }
    }

    @ApiOperation("根据条件查询列表-分页")
    @PostMapping({"queryListPage/{pageNum}/{pageSize}"})
    public Message queryListPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, @RequestBody T t) {
        try {
            return Message.success(this.baseService.queryListPage(pageNum, pageSize, t));
        } catch (Exception var5) {
            this.logger.error("分页查询异常：===》 " + var5);
            return Message.exception(var5.getMessage());
        }
    }*/
}
