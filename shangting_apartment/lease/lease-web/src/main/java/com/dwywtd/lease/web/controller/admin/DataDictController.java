package com.dwywtd.lease.web.controller.admin;

import com.dwywtd.lease.business.domain.DataDict;
import com.dwywtd.lease.business.service.DataDictService;
import com.dwywtd.lease.web.result.ResultBuild;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ResultBuild
@RestController
@RequestMapping("/admin/dataDict")
public class DataDictController {

    private final DataDictService dataDictService;


    public DataDictController(DataDictService dataDictService) {
        this.dataDictService = dataDictService;
    }

    @GetMapping("list")
    public List<DataDict> listDataDict() {
        return dataDictService.list();
    }
}
