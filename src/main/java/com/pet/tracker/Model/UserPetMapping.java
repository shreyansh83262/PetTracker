package com.pet.tracker.Model;

import javax.persistence.*;

@Entity
@Table(name = "userpetmapping")
public class UserPetMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "userid")
    private Long userid;

    @Column(name = "pettype")
    private String petType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public Long getPetTagid() {
        return petTagid;
    }

    public void setPetTagid(Long petTagid) {
        this.petTagid = petTagid;
    }

    @Column(name = "pettagid")
    private Long petTagid;
}
