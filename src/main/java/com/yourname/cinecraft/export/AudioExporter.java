package com.yourname.cinecraft.export;

import java.io.File;

/**
 * Handles audio export for CineCraft
 */
public class AudioExporter {

    private final File outputFile;

    public AudioExporter(File outputFile) {
        this.outputFile = outputFile;
    }

    public void exportAudio() {
        // Placeholder: real implementation mic / game audio hook se aayega
        System.out.println("[AudioExporter] Exporting audio to " + outputFile.getAbsolutePath());
    }

    public File getOutputFile() {
        return outputFile;
    }
}
