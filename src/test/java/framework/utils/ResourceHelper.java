package framework.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class ResourceHelper {
    static String getAbsolutePathToResource(String relativePathInResourceFolder) {
        return Thread.currentThread().getContextClassLoader().getResource(relativePathInResourceFolder).getPath();
    }

    static InputStream getResourceAsStream(String relativePathInResourceFolder) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(relativePathInResourceFolder);
    }

    static BufferedImage readImageFromFile(final String relativeResourcePath) {
        try {
            return ImageIO.read(
                    new File(
                            getAbsolutePathToResource(relativeResourcePath)
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    static void writeImageToFile(BufferedImage bufferedImage, final String relativeResourcePath) {
        try {
            ImageIO.write(bufferedImage, "png", new File(getAbsolutePathToResource(relativeResourcePath))
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}
