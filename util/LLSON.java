package util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * JSON相关工具类
 * 
 * @author Lollypo
 *
 */
/**
 * class [Z
class [Ljava.lang.Boolean;
class [D
class [Ljava.lang.Double;
class [I
class [Ljava.lang.Integer;
class [J
class [Ljava.lang.Long;
class [Ljava.lang.String;
 * @author Lollypo
 *
 */
public class LLSON {

	/**
	 * 将JSON字符串中的数据自动set到Bean对象中
	 * 
	 * @param res
	 *            JSON字符串
	 * @param bean
	 *            Bean对象
	 */
	public static Object fromJson(String res, Class<?> clazz) {
		Object result = null;
		try {
			result = Class.forName(clazz.getName()).newInstance();
			Field[] fields = clazz.getDeclaredFields();

			JSONObject root = new JSONObject(res);
			for (Field field : fields) {

				String type = field.getGenericType().toString();
				String fname = field.getName();
				Method method = null;
				// Int类型
				if (type.equals("int") || type.equals("class java.lang.Integer")) {
					method = clazz.getMethod("set" + getMethodName(fname),
							int.class);
					method.invoke(result, root.optInt(fname));
				// Int数组
				} if (type.equals("class [I") || type.equals("class [Ljava.lang.Integer")) {
//					method = clazz.getMethod("set" + getMethodName(fname),
//							int.class);
//					method.invoke(result, root.optInt(fname));
				// String类型
				}else if (type.equals("class java.lang.String")) {
					method = clazz.getMethod("set" + getMethodName(fname),
							String.class);
					method.invoke(result, root.optString(fname));
				// String数组
				} else if (type.equals("class [Ljava.lang.String;")) {
					method = clazz.getMethod("set" + getMethodName(fname),
							String[].class);
					JSONArray array = root.optJSONArray(fname);
					String[] subArray = new String[array.length()];
					for (int i = 0; i < array.length(); i++) {
						subArray[i] = array.optString(i);
					}
					method.invoke(result,new Object[] { subArray});
				// 其他类型
				} else {
					String clazzName = type.substring(6);
					JSONObject json = root.optJSONObject(fname);
					Class subClazz = Class.forName(clazzName);
					
					method = clazz.getMethod("set" + getMethodName(fname),
							subClazz);
					method.invoke(result,fromJson(json.toString(),subClazz));
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 把一个字符串的第一个字母大写、效率是最高的、
	private static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}
}
