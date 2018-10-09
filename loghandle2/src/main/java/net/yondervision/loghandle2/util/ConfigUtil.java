/**
 * @Title: ConfigUtil.java
 * @Package net.yondervision.loghandle2.util
 * @Description: TODO
 * Company:华信永道（北京）科技有限公司
 *
 * @author liym
 * @date 2014-11-5 下午05:25:26
 * @version V1.0
 */

package net.yondervision.loghandle2.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liym
 * @ClassName: ConfigUtil
 * @Description: TODO
 * @date 2014-11-5 下午05:25:26
 */

public class ConfigUtil {
    private static ConfigUtil initor = new ConfigUtil();

    private static Map<String, Object> configMap = new HashMap<String, Object>();

    private ConfigUtil() {
    }

    /**
     * 获取内容
     *
     * @param configFile
     * @return
     */
    public static PropertiesConfiguration get(String configFile) {
        if (!configMap.containsKey(configFile)) {
            initor.initConfig(configFile);
        }
        PropertiesConfiguration config = (PropertiesConfiguration) configMap.get(configFile);
        config.getString("ERROR04");
        return config;
    }

    /**
     * 载入配置文件，初始化后加入map
     *
     * @param configFile
     */
    public synchronized void initConfig(String configFile) {
        try {
            URL fileURL = Thread.currentThread().getContextClassLoader().getResource(configFile);
            PropertiesConfiguration config = new PropertiesConfiguration(fileURL);
            config.setReloadingStrategy(new FileChangedReloadingStrategy());
            configMap.put(configFile, config);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }


}
