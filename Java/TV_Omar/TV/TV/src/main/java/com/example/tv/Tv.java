package com.example.tv;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Tv {

    public static ObservableList<Channel> channels = FXCollections.observableArrayList();

    public static void initTv() {
        //LINK: https://www.tdtchannels.com/lists/tv.json

        /*//La 1
        //LOGO: https://pbs.twimg.com/profile_images/899385012801470464/akSvNCqE_200x200.jpg
        //URL: https://ztnr.rtve.es/ztnr/1688877.m3u8
        //URLLIVE: https://rtvelivestream.akamaized.net/rtvesec/la1/la1_main_dvr.m3u8
        List.of(new Channel(1, "La 1", "https://rtvelivestream.akamaized.net/rtvesec/la1/la1_main_dvr.m3u8", "https://pbs.twimg.com/profile_images/899385012801470464/akSvNCqE_200x200.jpg"));*/

        /*//La 2
        //LOGO: https://graph.facebook.com/la2detve/picture?width=200&height=200
        //URL: https://ztnr.rtve.es/ztnr/1688885.m3u8
        //URLLIVE: https://rtvelivestream.akamaized.net/rtvesec/la2/la2_main_dvr.m3u8
        List.of(new Channel(2, "La 2", "https://rtvelivestream.akamaized.net/rtvesec/la2/la2_main_dvr.m3u8", "https://graph.facebook.com/la2detve/picture?width=200&height=200"));*/

        /*//Trece
        //LOGO: https://graph.facebook.com/TRECEtves/picture?width=200&height=200
        //URL:
        //URLLIVE: https://play.cdn.enetres.net/091DB7AFBD77442B9BA2F141DCC182F5021/live.smil/playlist.m3u8
        List.of(new Channel(3, "Trece", "https://play.cdn.enetres.net/091DB7AFBD77442B9BA2F141DCC182F5021/live.smil/playlist.m3u8", "https://graph.facebook.com/TRECEtves/picture?width=200&height=200"));*/

        /*//El Toro TV
        //LOGO: https://graph.facebook.com/eltorotv.es/picture?width=200&height=200
        //URL: https://streaming-1.eltorotv.com/lb0/eltorotv-streaming-web/index.m3u8
        //URLLIVE: https://edge-nodo-002.streaming.hitcloser.net/eltorotv-streaming-web/index.m3u8
        List.of(new Channel(4, "El Toro TV", "https://edge-nodo-002.streaming.hitcloser.net/eltorotv-streaming-web/index.m3u8", "https://graph.facebook.com/eltorotv.es/picture?width=200&height=200"));*/

        /*//Informativos
        //LOGO: https://pbs.twimg.com/profile_images/1144547866393882626/2R0Khn5n_200x200.png
        //URL: https://ztnr.rtve.es/ztnr/1694255.m3u8
        //URLLIVE: https://rtvelivestream.akamaized.net/rtvesec/24h/24h_main_dvr.m3u8
        List.of(new Channel(5, "RTVE", "https://rtvelivestream.akamaized.net/rtvesec/24h/24h_main_dvr.m3u8", "https://pbs.twimg.com/profile_images/1144547866393882626/2R0Khn5n_200x200.png"));*/

        channels.addAll(List.of(
                new Channel(1, "La 1", "https://rtvelivestream.akamaized.net/rtvesec/la1/la1_main_dvr.m3u8", "https://pbs.twimg.com/profile_images/899385012801470464/akSvNCqE_200x200.jpg"),
                new Channel(2, "La 2", "https://rtvelivestream.akamaized.net/rtvesec/la2/la2_main_dvr.m3u8", "https://graph.facebook.com/la2detve/picture?width=200&height=200"),
                new Channel(3, "Trece", "https://play.cdn.enetres.net/091DB7AFBD77442B9BA2F141DCC182F5021/live.smil/playlist.m3u8", "https://graph.facebook.com/TRECEtves/picture?width=200&height=200"),
                new Channel(4, "El Toro TV", "https://edge-nodo-002.streaming.hitcloser.net/eltorotv-streaming-web/index.m3u8", "https://graph.facebook.com/eltorotv.es/picture?width=200&height=200"),
                new Channel(5, "RTVE", "https://rtvelivestream.akamaized.net/rtvesec/24h/24h_main_dvr.m3u8", "https://pbs.twimg.com/profile_images/1144547866393882626/2R0Khn5n_200x200.png")
                )
        );
    }
}
