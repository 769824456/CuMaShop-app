//package win.yulongsun.util;
//
//import android.text.TextUtils;
//
//import org.codehaus.jackson.JsonNode;
//import org.codehaus.jackson.JsonParseException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.type.TypeReference;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map.Entry;
//
///**
// * Json解析工具
// */
//public class JsonUtils {
//
//    private static ObjectMapper mapper;
//
//    /**
//     * 返回info
//     *
//     * @param json
//     * @return
//     * @throws IOException
//     */
//    public static String getInfo(String json) throws IOException {
//        mapper = new ObjectMapper();
//        return mapper.readTree(json).get("info").toString();
//    }
//
//    /**
//     * 返回Status
//     *
//     * @param json
//     * @return
//     * @throws IOException
//     */
//    public static int getStatus(String json) throws IOException {
//        mapper = new ObjectMapper();
//        return mapper.readTree(json).get("status").asInt();
//    }
//
//    /**
//     * 返回字符串
//     *
//     * @param json
//     * @return
//     * @throws IOException
//     */
//    public static String getDataStr(String json) throws IOException {
//        mapper = new ObjectMapper();
//        return mapper.readTree(json).get("data").toString();
//    }
//
//    /**
//     * HashMap转化成JSONString
//     */
//    public static String hashMap2Json(HashMap<String, Object> map) {
//        String string = "{";
//        for (Iterator it = map.entrySet().iterator(); it.hasNext(); ) {
//            Entry e = (Entry) it.next();
//            string += "\"" + e.getKey() + "\":";
//            string += "\"" + e.getValue() + "\",";
//        }
//        string = string.substring(0, string.lastIndexOf(","));
//        string += "}";
//        return string;
//    }
//
//    /**
//     * json转HashMap<String,Object>
//     *
//     * @param json
//     * @return
//     * @throws Exception
//     */
//    @SuppressWarnings("unchecked")
//    public static HashMap<String, Object> json2HashMap(String json)
//            throws Exception {
//
//        if (StringUtil.isEmpty(json))
//            return new HashMap<String, Object>();
//
//        mapper = new ObjectMapper();
//        //获取data节点
//        JsonNode data = mapper.readTree(json).get("data");
//        return (HashMap<String, Object>) mapper.readValue(data,
//                new TypeReference<HashMap<String, Object>>() {
//                });
//    }
//
//    /**
//     * json转HashMap<String,Object>
//     *
//     * @param json
//     * @return
//     * @throws Exception
//     */
//    @SuppressWarnings("unchecked")
//    public static HashMap<String, Object> json2HashMap(JsonNode json)
//            throws Exception {
//
//        if (StringUtil.isEmpty(json))
//            return new HashMap<String, Object>();
//        ObjectMapper mapper = new ObjectMapper();
//
//        return (HashMap<String, Object>) mapper.readValue(json,
//                new TypeReference<HashMap<String, Object>>() {
//                });
//    }
//
//    /**
//     * json转成List
//     *
//     * @param json
//     * @return
//     * @throws JsonParseException
//     * @throws JsonMappingException
//     * @throws IOException
//     */
//    public static List<HashMap<String, Object>> json2ListHashMap(String json)
//            throws JsonParseException, JsonMappingException, IOException {
//        if (TextUtils.isEmpty(json))
//            return new ArrayList<HashMap<String, Object>>();
//        ObjectMapper mapper = new ObjectMapper();
//        return (List<HashMap<String, Object>>) mapper.readValue(json,
//                new TypeReference<List<HashMap<String, Object>>>() {
//                });
//    }
//
//    /**
//     * json转成List
//     *
//     * @param json
//     * @return
//     * @throws JsonParseException
//     * @throws JsonMappingException
//     * @throws IOException
//     */
//    public static List<HashMap<String, Object>> json2ListHashMap(JsonNode json)
//            throws JsonParseException, JsonMappingException, IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        return (List<HashMap<String, Object>>) mapper.readValue(json,
//                new TypeReference<List<HashMap<String, Object>>>() {
//                });
//    }
//
//    /**
//     * 把实体转换成json字符串
//     * HashMap
//     *
//     * @return
//     * @throws Exception
//     */
//    public static String objectToJson(Object obj) throws Exception {
//
//        if (obj == null)
//            return "";
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        return mapper.writeValueAsString(obj);
//    }
//
//
//    public static <T> T json2Entity(String jsonStr, Class<T> valueType) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(jsonStr, valueType);
//    }
//
//
//}
