package io.wonderf.factory.service.db.service;

import io.wonderf.factory.service.db.entity.Account;
import io.wonderf.factory.service.db.entity.ProxySettings;
import io.wonderf.factory.service.db.model.ProxyDto;

public interface ProxySettingsService {
    ProxySettings attach(Integer accountId, ProxyDto proxyDto);
    void delete(ProxyDto proxyDto);
}
