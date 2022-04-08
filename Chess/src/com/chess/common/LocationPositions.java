package com.chess.common;

public class LocationPositions {
    private static final File[] files = File.values();
    public static Location build (Location current, Integer fileOffset, Integer rankOffset){
        Integer currentFile = current.getFile().ordinal();
        return new Location(files[currentFile + fileOffset], current.getRank() + rankOffset);
    }
}
