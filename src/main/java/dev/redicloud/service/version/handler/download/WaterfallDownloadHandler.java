package dev.redicloud.service.version.handler.download;

import dev.redicloud.service.version.utils.URLUtils;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class WaterfallDownloadHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String version = ctx.pathParam("version");
        String build = ctx.pathParam("build");
        if(build.equalsIgnoreCase("latest") || build.equalsIgnoreCase("newest")){
            String content = URLUtils.getContent("https://papermc.io/api/v2/projects/waterfall/versions/" + version + "/builds");
            JSONObject json = new JSONObject(content);
            int i = 0;
            for (int i1 = 0; i1 < json.getJSONArray("builds").length(); i1++) {
                JSONObject entry = json.getJSONArray("builds").getJSONObject(i1);
                if(entry.getInt("build") > i){
                    i = entry.getInt("build");
                }
            }
            build = String.valueOf(i);
        }
        ctx.redirect("https://api.papermc.io/v2/projects/waterfall/versions/" + version
                + "/builds/" + build
                + "/downloads/waterfall-" + version + "-" + build +".jar");
    }
}
