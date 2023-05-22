package io.wonderf.factory.service.db.model;

import io.wonderf.factory.service.db.entity.Account;
import io.wonderf.factory.service.db.entity.ProxySettings;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto extends Account {
    private Integer id;
    private String username;
    private String pass;
    private ProxySettings setting;
}
