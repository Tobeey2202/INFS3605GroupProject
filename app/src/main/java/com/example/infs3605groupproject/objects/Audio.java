package com.example.infs3605groupproject.objects;

public class Audio {
    private String audioFilePath;
    private String audioTitle;

    public Audio(String audioFilePath, String audioTitle) {
        this.audioFilePath = audioFilePath;
        this.audioTitle = audioTitle;
    }

    public String getAudioFilePath() {
        return audioFilePath;
    }

    public void setAudioFilePath(String audioFilePath) {
        this.audioFilePath = audioFilePath;
    }

    public String getAudioTitle() {
        return audioTitle;
    }

    public void setAudioTitle(String audioTitle) {
        this.audioTitle = audioTitle;
    }
}
