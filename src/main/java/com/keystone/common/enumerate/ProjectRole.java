package com.keystone.common.enumerate;

import java.util.Set;

public enum ProjectRole {

    VIEWER(Set.of("READ")),

    EDITOR(Set.of("READ", "UPDATE")),

    CONTRIBUTOR(Set.of("READ", "CREATE", "UPDATE")),

    ADMIN(Set.of("READ", "CREATE", "UPDATE", "DELETE", "MANAGE"));

    private final Set<String> permissions;

    ProjectRole(Set<String> permissions) {
        this.permissions = permissions;
    }

    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }
}