/**
 * @Title: TPropertiesConfiguration.java
 * @Package net.yondervision.utilhandle
 * @Description: TODO
 * Company:华信永道（北京）科技有限公司
 *
 * @author liym
 * @date 2014-11-5 下午02:12:17
 * @version V1.0
 */

package net.yondervision.loghandle2.util;

import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.List;

/**
 * @author liym
 * @ClassName: TPropertiesConfiguration
 * @Description: 文件操作类
 * @date 2014-11-5 下午02:12:17
 */

public class PropertiesUtil {

    private PropertiesConfiguration propConfig;
    private String fileName;

    private PropertiesUtil(String fileName) {
        this.fileName = fileName;
        propConfig = ConfigUtil.get(this.fileName);
    }

    public static PropertiesUtil getInstance(String fileName) {
        return new PropertiesUtil(fileName);
    }

    /**
     * 获取property文件中单一属性值
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return propConfig.getString(key);
    }

    /**
     * getString
     *
     * @param @param  key key值
     * @param @param  def 默认值
     * @param @return 设定文件
     * @return String    返回类型
     * @throws
     * @Title: getString
     * @Description: TODO
     */


    public String getString(String key, String def) {
        return propConfig.getString(key, def);
    }

    /**
     * getInt
     *
     * @param @param  key
     * @param @return 设定文件
     * @return int    返回类型
     * @throws
     * @Title: getInt
     * @Description: TODO
     */


    public int getInt(String key) {
        return propConfig.getInt(key);
    }

    /**
     * getInt
     *
     * @param @param  key
     * @param @param  def
     * @param @return 设定文件
     * @return int    返回类型
     * @throws
     * @Title: getInt
     * @Description: TODO
     */


    public int getInt(String key, int def) {
        return propConfig.getInt(key, def);
    }

    /**
     * getLong
     *
     * @param @param  key
     * @param @return 设定文件
     * @return long    返回类型
     * @throws
     * @Title: getLong
     * @Description: TODO
     */


    public long getLong(String key) {
        return propConfig.getLong(key);
    }

    /**
     * getLong
     *
     * @param @param  key
     * @param @param  def
     * @param @return 设定文件
     * @return long    返回类型
     * @throws
     * @Title: getLong
     * @Description: TODO
     */


    public long getLong(String key, long def) {
        return propConfig.getLong(key, def);
    }

    /**
     * getFloat
     *
     * @param @param  key
     * @param @return 设定文件
     * @return float    返回类型
     * @throws
     * @Title: getFloat
     * @Description: TODO
     */


    public float getFloat(String key) {
        return propConfig.getFloat(key);
    }

    /**
     * getFloat
     *
     * @param @param  key
     * @param @param  def
     * @param @return 设定文件
     * @return float    返回类型
     * @throws
     * @Title: getFloat
     * @Description: TODO
     */


    public float getFloat(String key, float def) {
        return propConfig.getFloat(key, def);
    }

    /**
     * getDouble
     *
     * @param @param  key
     * @param @return 设定文件
     * @return double    返回类型
     * @throws
     * @Title: getDouble
     * @Description: TODO
     */


    public double getDouble(String key) {
        return propConfig.getDouble(key);
    }

    /**
     * getDouble
     *
     * @param @param  key
     * @param @param  def
     * @param @return 设定文件
     * @return double    返回类型
     * @throws
     * @Title: getDouble
     * @Description: TODO
     */


    public double getDouble(String key, double def) {
        return propConfig.getDouble(key, def);
    }

    /**
     * getBoolean
     *
     * @param @param  key
     * @param @return 设定文件
     * @return boolean    返回类型
     * @throws
     * @Title: getBoolean
     * @Description: TODO
     */


    public boolean getBoolean(String key) {
        return propConfig.getBoolean(key);
    }

    /**
     * getBoolean
     *
     * @param @param  key
     * @param @param  def
     * @param @return 设定文件
     * @return boolean    返回类型
     * @throws
     * @Title: getBoolean
     * @Description: TODO
     */


    public boolean getBoolean(String key, boolean def) {
        return propConfig.getBoolean(key, def);
    }

    /**
     * getStringArray
     *
     * @param @param  key
     * @param @return 设定文件
     * @return String[]    返回类型
     * @throws
     * @Title: getStringArray
     * @Description: TODO
     */


    public String[] getStringArray(String key) {
        return propConfig.getStringArray(key);
    }

    /**
     * getList
     *
     * @param @param  key
     * @param @return 设定文件
     * @return List    返回类型
     * @throws
     * @Title: getList
     * @Description: TODO
     */


    @SuppressWarnings("rawtypes")
    public List getList(String key) {
        return propConfig.getList(key);
    }

    /**
     * getList
     *
     * @param @param  key
     * @param @param  def
     * @param @return 设定文件
     * @return List    返回类型
     * @throws
     * @Title: getList
     * @Description: TODO
     */


    @SuppressWarnings("rawtypes")
    public List getList(String key, List def) {
        return propConfig.getList(key, def);
    }

    /**
     * setProperty
     *
     * @param @param key
     * @param @param value    设定文件
     * @return void    返回类型
     * @throws
     * @Title: setProperty
     * @Description: TODO
     */


    public void setProperty(String key, Object value) {
        propConfig.setProperty(key, value);
    }

}
