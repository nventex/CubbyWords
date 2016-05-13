package com.nventex.core.sounds;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import java.util.HashMap;
import java.util.List;

public class SoundManager {
    private Activity activity;
    private HashMap<Integer, Integer> loadedSounds;
    private SoundPool soundPool;
    private List<Integer> sounds;

    /* renamed from: com.nventex.core.sounds.SoundManager.1 */
    class C00021 implements OnLoadCompleteListener {
        C00021() {
        }

        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        }
    }

    public SoundManager(Activity activity) {
        this.activity = activity;
        initializeSoundPool();
    }

    private void initializeSoundPool() {
        this.activity.setVolumeControlStream(3);
        this.soundPool = new SoundPool(1, 3, 0);
    }

    public void setSounds(List<Integer> sounds) {
        this.sounds = sounds;
        loadSound();
    }

    private float getVolumeSettings() {
        AudioManager audioManager = (AudioManager) this.activity.getSystemService("audio");
        return ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
    }

    private void loadSound() {
        this.loadedSounds = new HashMap();
        this.soundPool.setOnLoadCompleteListener(new C00021());
        for (Integer sound : this.sounds) {
            this.loadedSounds.put(sound, Integer.valueOf(this.soundPool.load(this.activity.getApplicationContext(), sound.intValue(), 1)));
        }
    }

    public void playSound(int soundId) {
        float volume = getVolumeSettings();
        if (this.loadedSounds.containsKey(Integer.valueOf(soundId))) {
            this.soundPool.play(((Integer) this.loadedSounds.get(Integer.valueOf(soundId))).intValue(), volume, volume, 1, 0, 1.0f);
        }
    }
}
