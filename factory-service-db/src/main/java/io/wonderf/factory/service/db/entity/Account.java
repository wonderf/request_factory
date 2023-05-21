package io.wonderf.factory.service.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "pass")
    private String pass;

    @OneToOne(cascade = {CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JoinColumn(name = "proxy_id")
    private ProxySettings setting;
}
