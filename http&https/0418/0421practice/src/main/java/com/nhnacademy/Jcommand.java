package com.nhnacademy;


import com.beust.jcommander.Parameter;



public class Jcommand {

    @Parameter(names="-v", description = "모든 정보 출력합니다.")
    private boolean verbose;      //default는 false  만약에 넘어온 인자가 있으면 true

    @Parameter(names="-H", description = "헤더 정보를 추가합니다.")
    private String header;       

     /**
     * 나머지 curl 옵션도 추가하기
     */

    public boolean isVerbose() {
        return verbose;
    }

    public String getHeader() {
        return header;
    }


}
