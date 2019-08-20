package org.apirest.security;

public interface SecurityParams {

    // Constante security filter

    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="t3sts3cr3t";
    public static final long EXPIRATION=10*24*3600;
    public static final String HEADER_PREFIX="Bearer ";
}
