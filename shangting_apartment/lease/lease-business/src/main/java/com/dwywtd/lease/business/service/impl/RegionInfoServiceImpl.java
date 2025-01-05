package com.dwywtd.lease.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dwywtd.lease.business.domain.CityInfo;
import com.dwywtd.lease.business.domain.DistrictInfo;
import com.dwywtd.lease.business.domain.ProvinceInfo;
import com.dwywtd.lease.business.mapper.CityInfoMapper;
import com.dwywtd.lease.business.mapper.DistrictInfoMapper;
import com.dwywtd.lease.business.mapper.ProvinceInfoMapper;
import com.dwywtd.lease.business.service.RegionInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionInfoServiceImpl implements RegionInfoService {

    private final CityInfoMapper cityInfoMapper;
    private final DistrictInfoMapper districtInfoMapper;
    private final ProvinceInfoMapper provinceInfoMapper;

    public RegionInfoServiceImpl(CityInfoMapper cityInfoMapper, DistrictInfoMapper districtInfoMapper, ProvinceInfoMapper provinceInfoMapper) {
        this.cityInfoMapper = cityInfoMapper;
        this.districtInfoMapper = districtInfoMapper;
        this.provinceInfoMapper = provinceInfoMapper;
    }

    @Override
    public List<ProvinceInfo> listProvince() {
        return provinceInfoMapper.selectList(null);
    }

    @Override
    public List<CityInfo> listCityInfoByProvinceId(Long provinceId) {
        LambdaQueryWrapper<CityInfo> queryWrapper = new LambdaQueryWrapper<CityInfo>().eq(CityInfo::getProvinceId, provinceId);
        return cityInfoMapper.selectList(queryWrapper);
    }

    @Override
    public List<DistrictInfo> listDistrictInfoByCityId(Long cityId) {
        LambdaQueryWrapper<DistrictInfo> queryWrapper = new LambdaQueryWrapper<DistrictInfo>().eq(DistrictInfo::getCityId, cityId);
        return districtInfoMapper.selectList(queryWrapper);
    }
}
