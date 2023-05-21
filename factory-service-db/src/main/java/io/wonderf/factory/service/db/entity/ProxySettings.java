package io.wonderf.factory.service.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "proxy_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProxySettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String pass;

    @Column(name = "ip")
    private String ip;

    @Column(name = "port")
    private Integer port;

    @OneToOne(mappedBy = "setting")
    private Account accounts;
}
