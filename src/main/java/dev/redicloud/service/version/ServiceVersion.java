package dev.redicloud.service.version;

public enum ServiceVersion {

    VERSION_1_8_8,
    VERSION_1_8_9,
    VERSION_1_9_4,
    VERSION_1_10_2,
    VERSION_1_11_2,
    VERSION_1_12_2,
    VERSION_1_13_2,
    VERSION_1_14_4,
    VERSION_1_15_2,
    VERSION_1_16_5,
    VERSION_1_17_1,
    VERSION_1_18_2,
    VERSION_1_19_2;

    public String getApiName(){
        return this.name().replaceAll("_", ".").replaceAll("VERSION.", "");
    }

    public static ServiceVersion fromApiName(String apiName){
        for(ServiceVersion version : ServiceVersion.values()){
            if(version.getApiName().equals(apiName)){
                return version;
            }
        }
        return null;
    }

}
