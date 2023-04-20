package vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.constant.ERole;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.Roles;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles,Integer> {
    public Optional<Roles> findRolesByName(ERole name);
}
