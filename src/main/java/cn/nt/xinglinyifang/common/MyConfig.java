package cn.nt.xinglinyifang.common;

import cn.nt.xinglinyifang.model.*;
import com.jfinal.config.*;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class MyConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        me.setUrlParaSeparator("&");
        PropKit.use("config.properties");
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {

    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {
        //druid 数据源插件
        DruidPlugin dp = new DruidPlugin(PropKit.get("url"),PropKit.get("username"),PropKit.get("password"));
        dp.setDriverClass(PropKit.get("driverClass"));
        dp.set(PropKit.getInt("initialSize"), PropKit.getInt("minIdle"), PropKit.getInt("maxActive"));
        dp.setMaxWait(PropKit.getInt("maxWait"));
        me.add(dp);
        //ARP插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(arp);
        arp.setBaseSqlTemplatePath(PathKit.getWebRootPath() + "/WEB-INF");
        arp.addSqlTemplate("sql/all.sql");
        arp.addMapping("activation", Activation.class);
        arp.addMapping("disease", Disease.class);
        arp.addMapping("doctor", Doctor.class);
        arp.addMapping("medicalCase", MedicalCase.class);
        arp.addMapping("medicine", Medicine.class);
        arp.addMapping("Picture", Picture.class);
        arp.addMapping("relationship", Relationship.class);
        arp.addMapping("technology", Technology.class);
        arp.addMapping("video", Video.class);

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
