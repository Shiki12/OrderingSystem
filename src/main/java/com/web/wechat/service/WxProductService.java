package com.web.wechat.service;

import com.web.wechat.dataUtil.ResponseData;

public interface WxProductService {

    ResponseData getProInfos();

    ResponseData getProNum();

    ResponseData getProDetail(int id);
}
