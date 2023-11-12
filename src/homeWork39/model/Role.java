package homeWork39.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Role {
    private String roleName;

    //private Role role;
    private Map<Role, List<String>> rolePermissions;

    public Role(String roleName) {
        this.roleName = roleName;
        this.rolePermissions = new HashMap<>();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void assignPermissions(List<String> permissions) {
        rolePermissions.put(this, permissions);
    }

    public List<String> getPermissionsForRole(Role role) {
        return rolePermissions.getOrDefault(this, Collections.emptyList());
    }
}

