package io.wonderf.factory.service.db.repository;

import io.wonderf.factory.service.db.entity.ProxySettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProxySettingsRepository extends JpaRepository<ProxySettings,Integer> {
}
