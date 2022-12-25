package com.shrijee.learn.springSecurity.Security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationUserPermissions.COURSE_READ,ApplicationUserPermissions.COURSE_WRITE,ApplicationUserPermissions.STUDENT_READ,ApplicationUserPermissions.STUDENT_WRITE));

    private final Set<ApplicationUserPermissions> permissionsSet;

    ApplicationUserRole(Set<ApplicationUserPermissions> permissionsSet)
    {
        this.permissionsSet = permissionsSet;
    }
}
