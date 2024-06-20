package com.exemplo.demo.dto;

import com.exemplo.demo.entity.Casting;
import com.exemplo.demo.entity.CastingRole;
import lombok.Data;

@Data
public class CastingDTO {
    private Integer id;
    private String name;
    private CastingRole castingRole;

    public static CastingDTO fromEntity(Casting casting) {
        CastingDTO castingDTO = new CastingDTO();
        castingDTO.setId(casting.getId());
        castingDTO.setName(casting.getName());
        castingDTO.setCastingRole(casting.getRole());
        return castingDTO;
    }
}
