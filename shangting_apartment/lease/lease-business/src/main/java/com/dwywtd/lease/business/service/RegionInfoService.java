package com.dwywtd.lease.business.service;

import com.dwywtd.lease.business.domain.CityInfo;
import com.dwywtd.lease.business.domain.DistrictInfo;
import com.dwywtd.lease.business.domain.ProvinceInfo;

import java.util.List;

public interface RegionInfoService {
    List<ProvinceInfo> listProvince();

    List<CityInfo> listCityInfoByProvinceId(Long provinceId);


    List<DistrictInfo> listDistrictInfoByCityId(Long cityId);

}
