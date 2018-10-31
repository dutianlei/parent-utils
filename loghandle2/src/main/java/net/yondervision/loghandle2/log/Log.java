/**
 * @Title: Log.java
 * @Package com.yondervision.cbb.commons.log
 * @Description: TODO 
 * Company:华信永道（北京）科技有限公司
 * 
 * @author liym
 * @date 2014-10-29 下午04:27:51
 * @version V1.0
 */

package net.yondervision.loghandle2.log;

import net.yondervision.loghandle2.util.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * 自定义日志类
 * @author Mr.Du
 * @Date 2018/9/20_16:07
 */
public class Log {
	
	private static PropertiesUtil properUtilsPath = PropertiesUtil.getInstance("loghandle.properties");
    private static PropertiesUtil properUtilsCode = PropertiesUtil.getInstance("messageCode.properties");
	private static Logger logger = LoggerFactory.getLogger(Log.class);
    private static final String STARTCHAR = "{";
  	private static final String ENDCHAR = "}";
//    private static String COMPUTERNAME = SysPropertyUtils.getLocalhostIP();
//    private static ConcurrentMap config= null;
	/**
	 * 一级目录
	 */
	private static final String ADIR = properUtilsPath.getString("adirectory");
	/**
	 * 二级目录
	 */
	private static final String BDIR = properUtilsPath.getString("bdirectory");

	/**
	 * 日志路径
	 */
	private static final String LOGPATH = properUtilsPath.getString("logPath");
	public Log(Class<?> clazz){
		logger = LoggerAdapterFactory.getLoggerAdapter(clazz);
		loadConfig("");
	}


    /**
     * debug模式异常日志
     * @param logModel 日志模块，暂未用到此参数，可后续扩展
     * @param ex 异常信息
     * @param params 需要打印的用户自定义日志信息
     */
	public static void debug(String msgCode,LogModel logModel, Throwable ex, String... params) {
        if(!checkIsPrintByLogModel()) return;
		try {
            String msg = getMessage(msgCode,params);
            logger.debug(msg, ex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * debug模式日志
     * @param logModel 日志模块，暂未用到此参数，可后续扩展
     * @param params 需要打印的用户自定义日志信息
     */
    public static void debug(String msgCode,LogModel logModel, String... params) {
        if(!checkIsPrintByLogModel()) return;
        try {
            String msg = getMessage(msgCode,params);
            logger.debug(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * error模式异常日志
     * @param logModel 日志模块，暂未用到此参数，可后续扩展
     * @param ex 异常信息
     * @param params 需要打印的用户自定义日志信息
     */
 	public static void error(String msgCode,LogModel logModel, Throwable ex, String... params) {
        if(!checkIsPrintByLogModel()) return;
 		try {
             String msg = getMessage(msgCode,params);
             logger.error(msg, ex);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 	}
    /**
     * error模式日志
     * @param logModel 日志模块，暂未用到此参数，可后续扩展
     * @param params 需要打印的用户自定义日志信息
     */
     public static void error(String msgCode,LogModel logModel, String... params) {
         if(!checkIsPrintByLogModel()) return;
         try {
             String msg = getMessage(msgCode,params);
             logger.error(msg);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

    /**
     * info模式异常日志
     * @param logModel 日志模块，暂未用到此参数，可后续扩展
     * @param ex 异常信息
     * @param params 需要打印的用户自定义日志信息
     */
  	public static void info(String msgCode,LogModel logModel, Throwable ex, String... params) {
        if(!checkIsPrintByLogModel()) return;
  		try {
              String msg = getMessage(msgCode,params);
              logger.info(msg, ex);
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
    /**
     * info模式日志
     * @param logModel 日志模块，暂未用到此参数，可后续扩展
     * @param params 需要打印的用户自定义日志信息
     */
    public static void info(String msgCode,LogModel logModel, String... params) {
        if(!checkIsPrintByLogModel()) return;
        try {
            String msg = getMessage(msgCode,params);
            logger.info(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取日志文件名
     * @return 日志文件名
     * @date 2018-09-20 Mr.Du
     */
	private static String getLogFileName(String methodName) {
        String logFileName = "";
	    try {
            //2015-08-04 liym start 添加对日期文件夹生成的控制
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            //获取日志路径
            String currentDate = dateFormat.format(calendar.getTime());
            String path = LOGPATH + File.separator + ADIR + File.separator + BDIR + File.separator + currentDate + File.separator;

            File file = new File(path);
            if (!file.exists()) {
                if (file.mkdir()) {
                    //执行权限
                    file.setExecutable(true, false);
                    //读的权限
                    file.setReadable(true, false);
                    //写的权限
                    file.setWritable(true, false);
                }
            }
            logFileName = path + File.separator + BDIR + "_" + methodName;

        }catch (Exception e) {
	        e.printStackTrace();
        }
        return logFileName;
    }

    /**
     * warn模式异常日志
     * @param logModel 日志模块，暂未用到此参数，可后续扩展
     * @param ex 异常信息
     * @param params 需要打印的用户自定义日志信息
     */
  	public static void warn(String msgCode,LogModel logModel, Throwable ex, String... params) {
        if(!checkIsPrintByLogModel()) return;
  		try {
              String msg = getMessage(msgCode,params);
              logger.warn(msg, ex);
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
    /**
     * warn模式日志
     * @param logModel 日志模块，暂未用到此参数，可后续扩展
     * @param params 需要打印的用户自定义日志信息
     */
    public static void warn(String msgCode,LogModel logModel, String... params) {
        if(!checkIsPrintByLogModel()) return;
        try {
            String msg = getMessage(msgCode,params);
            logger.warn(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 检查该级别日志是否打印
     * @return true:打印，false:不打印
     */
	private static Boolean checkIsPrintByLogModel() {
	    //获得堆栈信息
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        //获得调用此方法的方法名称
        String methodName = stackTraceElement[2].getMethodName();
        //获得配置文件中配置打印的日志级别
        String[] prints = properUtilsPath.getStringArray("printLevel");
        for(int i = 0 ; i < prints.length ; i++) {
            prints[i] = prints[i].toUpperCase();
        }
        boolean contains = Arrays.asList(prints).contains(methodName.toUpperCase());
        return contains;
    }
    /**
        * 根据传入参数，封装日志打印消息
        * @param params 传入的参数
        * @return 打印logger日志
        */
       private static String getMessage(String msgCode,String[] params) {
           //获得堆栈信息
           StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
           //获得调用此方法的方法名称
           String methodName2 = stackTraceElement[2].getMethodName();
           String methodName3 = stackTraceElement[3].getMethodName();
           String className3 = stackTraceElement[3].getClassName();
           String fileName3 = stackTraceElement[3].getFileName();
           int lineNumber3 = stackTraceElement[3].getLineNumber();
           String logFileName = getLogFileName(methodName2);
           //拼装文件名称
           MDC.put("fileName", logFileName);

           String message = properUtilsCode.getString(msgCode);
           String [] messageArg = message.split(",");
           StringBuilder sbMsg = new StringBuilder();
//           message="";
           for(int j=0;j<params.length;j++){
               if(j==params.length-1){
//                   message=sbMsg+messageArg[j];
                   sbMsg.append(messageArg[j]);
               }else{
//                   message=sbMsg+messageArg[j]+",";
                   sbMsg.append(messageArg[j]).append(",");
               }
           }
           System.out.println("sbMsg:" + sbMsg.toString());
           int i =1;
           message = sbMsg.toString();
           for(String str : params){
               String placeHolder=STARTCHAR+i+ENDCHAR;
               message = StringUtils.replaceOnce(message, placeHolder, str);
               i++;
           }
     		String callPath = className3 + "." + methodName3 + "(" + fileName3 + ":" + lineNumber3 + ")";
     		// 获取当前线程名称
     		String threadName = Thread.currentThread().getName();
     		// 获取系统时间
     		String systime = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSS").format(System.currentTimeMillis());
     		// 组成打印信息
     		message = "["+threadName+"]- "+systime + "- " + callPath + " -[" + methodName2 + "]" +"-" + message + "。";
     		return message;
     	}
    /**
     * 根据传入参数，封装日志打印消息
     * @param params 传入的参数
     * @return 打印logger日志
     */
//    private static String getMessage(String msgCode,String[] params) {
//        //获得堆栈信息
//        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
//        //获得调用此方法的方法名称
//        String methodName2 = stackTraceElement[2].getMethodName();
//        String methodName3 = stackTraceElement[3].getMethodName();
//        String className3 = stackTraceElement[3].getClassName();
//        String fileName3 = stackTraceElement[3].getFileName();
//        int lineNumber3 = stackTraceElement[3].getLineNumber();
//        String logFileName = getLogFileName(methodName2);
//        //拼装文件名称
//        MDC.put("fileName", logFileName);
//        int i =1;
//        String message = properUtilsCode.getString(msgCode);
//        for(String str : params){
//            String placeHolder=STARTCHAR+i+ENDCHAR;
//            message = StringUtils.replaceOnce(message, placeHolder, str);
//            i++;
//        }
////        if (params.length >=1 && params.length < message.split(",").length) {
////            int i1 = StringUtils.ordinalIndexOf(message, ",", params.length);
////            message = message.substring(0,i1);
////        }
////        if(params.length <=0) {
////            message = "";
////        }
//
////        int i = 0;
////        StringBuffer sb = new StringBuffer();
////        for(String str : params){
////            sb = i == params.length - 1 ? sb.append(str + "。") : sb.append(str + ",");
////            i++;
////        }
//        //需要打印的日志信息
////        String message =  sb.toString();
//  		String callPath = className3 + "." + methodName3 + "(" + fileName3 + ":" + lineNumber3 + ")";
//  		// 获取当前线程名称
//  		String threadName = Thread.currentThread().getName();
//  		// 获取系统时间
//  		String systime = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSS").format(System.currentTimeMillis());
//  		// 组成打印信息
//  		message = "["+threadName+"]- "+systime + "- " + callPath + " -[" + methodName2 + "]" +"-" + message + "。";
//  		return message;
//  	}

	public static void loadConfig(String fileName) {
		/*LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(lc);
		lc.reset();
		try {
			String path = Log.class.getResource("/").getFile();
			configurator.doConfigure(path + "logback2.xml");
		} catch (JoranException e) {
			e.printStackTrace();
		}*/
		// StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
		//TODO 可以自定义加载配置文件，暂时什么都不做
		
	}
	/**
	 * <pre> 将堆栈转化成字符串 </pre>
	 * @param t 异常堆栈
	 */
	public static String convertStackTraceToString(Throwable t) {
		StringBuffer sb = new StringBuffer();
		if (null != t) {
			if (null != t.getCause() && null != t.getCause().getStackTrace()) {
				sb.append(Log.convertStackTraceToString(t.getCause()) + "\n");
			}
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw, true);
			t.printStackTrace(pw);
			pw.flush();
			sw.flush();
			String value = sw.toString();
			try {
				pw.close();
				sw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return sb.append(value).toString();
		} else {
			return null;
		}
	}

	
}
