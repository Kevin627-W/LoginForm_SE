package model;

public class LoginAudit {

    private String username;
    private String ipAddress;
    private String userAgent;
    private String deviceType;
    private boolean successful;
    private int failedAttemptCount;
    private boolean twoFactorVerified;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }

    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

    public boolean isSuccessful() { return successful; }
    public void setSuccessful(boolean successful) { this.successful = successful; }

    public int getFailedAttemptCount() { return failedAttemptCount; }
    public void setFailedAttemptCount(int failedAttemptCount) { this.failedAttemptCount = failedAttemptCount; }

    public boolean isTwoFactorVerified() { return twoFactorVerified; }
    public void setTwoFactorVerified(boolean twoFactorVerified) { this.twoFactorVerified = twoFactorVerified; }
}