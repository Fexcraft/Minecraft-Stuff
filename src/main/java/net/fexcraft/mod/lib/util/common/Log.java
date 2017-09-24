package net.fexcraft.mod.lib.util.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	private final Logger logger;
	
	public Log(String id){
		logger = LogManager.getLogger(id);
	}
	
	public void log(Object obj){
		if(obj instanceof Iterable){
			Iterable inte = (Iterable)obj;
			logger.info("ITERABLE: {");
			for(Object object : inte){
				logger.info("    " + (object == null ? ";>> null >>;" : String.valueOf(object)));
			}
			logger.info("}");
			return;
		}
		logger.info(obj == null ? ";>> null >>;" : String.valueOf(obj));
	}

	public void log(Object... objs){
		String str = "[";
		for(int i = 0; i < objs.length; i++){
			str += objs[i] == null ? ";>> null >>;" : String.valueOf(objs[i]) + (i == objs.length - 1 ? "" : ", ");
		}
		log(str + "]");
	}
	
	public void log(Object prefix, Object obj){
		logger.info("[" + String.valueOf(prefix) + "]> " + String.valueOf(obj));
	}

	public void debug(Object obj){
		if(Static.dev()){
			log(obj);
		}
	}
	
	public void debug(Object... objs){
		if(Static.dev()){
			log(objs);
		}
	}
	
}