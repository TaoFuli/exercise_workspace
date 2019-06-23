package com.igeek.controller;

import com.igeek.pojo.TbItem;
import com.igeek.service.ItemService;
import com.igeek.util.datagrid.DataGridNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;


    /**
     * 根据页码以及每页的条数 返回每页的数据
     * @param page 页码
     * @param rows 每页的条数
     * @return
     */
    @RequestMapping("/list")
    public DataGridNode<TbItem> itemList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows){

        return itemService.selectItemsByPage(page,rows);
    }
}
