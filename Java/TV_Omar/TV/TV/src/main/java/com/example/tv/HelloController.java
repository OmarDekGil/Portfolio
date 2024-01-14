package com.example.tv;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class HelloController {

    @FXML
    public ListView<Channel> listChannels;

    public void initialize() {
        Tv.initTv();
        listChannels.setItems(Tv.channels);
        listChannels.setCellFactory(list -> new ListCell<Channel>() {
            MediaView video = new MediaView();

            {
                video.autosize();
                video.setPreserveRatio(true);
                video.setFitHeight(320);
                setAlignment(Pos.CENTER);
            }

            @Override
            protected void updateItem(Channel channel, boolean empty) {
                super.updateItem(channel, empty);

                if (channel == null || empty) {
                    setGraphic(null);
                    return;
                }
                if(video.getMediaPlayer() == null || (video.getMediaPlayer() !=null && video.getMediaPlayer().getMedia().getSource() != channel.getUrl())){
                    MediaPlayer player = new MediaPlayer(new Media(channel.getUrl()));

                    player.setAutoPlay(true);
                    video.setMediaPlayer(player);
                    player.statusProperty().addListener((observableValue, status, t1) -> {
                        System.out.println("Cambio en el player: " + player.getStatus() + " en el link: " + player.getMedia().getSource());
                    });
                    setGraphic(video);
                }

            }
        });
    }

}