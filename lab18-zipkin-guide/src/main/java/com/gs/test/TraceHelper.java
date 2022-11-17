package com.gs.test;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.tracing.ZipkinTracerBean;
import io.opentracing.Scope;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

import java.util.concurrent.Callable;

    public class TraceHelper {
    private static ZipkinTracerBean tracingBean;
    private static TraceHelper helper;
    public static String zipkinurl = "http://localhost:9411/";


    protected TraceHelper() {
        tracingBean = new ZipkinTracerBean("test").setStartActive(true).setZipkinUrl(zipkinurl);
        tracingBean.start();
    }

    static public TraceHelper getInstance() {
        if (helper != null)
            return helper;
        helper = new TraceHelper();
        return helper;
    }

    public static <T> T wrap(String name, Callable<T> c) throws Exception {
        if (GlobalTracer.isRegistered()) {
            Tracer tracer = GlobalTracer.get();
            io.opentracing.Span span = tracer.buildSpan(name).start();
            //noinspection unused
            try (Scope scope = tracer.scopeManager().activate(span)) {
                return c.call();
            } catch (Exception e) {
                span.log(e.toString());
                throw e;
            } finally {
                // Optionally finish the Span if the operation it represents
                // is logically completed at this point.
                span.finish();
            }
        } else {
            return c.call();
        }
    }

    /**
     * Test
     * @param args
     */
    static GigaSpace gs;
    public static void main(String[] args) throws Exception {
        TraceHelper helper = TraceHelper.getInstance();
        Tracer tracer = GlobalTracer.get();
        gs = new GigaSpaceConfigurer(new SpaceProxyConfigurer("demo").lookupGroups("xap-16.2.0")).create();
        wrap("write", () -> {
            write();
            return 0;
        });

        wrap("read", () -> {
            read();
            return 0;
        });

        helper.close();
    }

    public static void read() {
        gs.read(new MyTest());
    }

    public static void write() {
        gs.write(new MyTest("3","myTest"));
    }

    public static void close(){
        if (tracingBean != null){
            try {
                tracingBean.destroy();
            }
            catch (Exception e){}
        }
    }

    public static class MyTest implements java.io.Serializable{
        String id;
        String txt;

        public MyTest() {
        }

        public MyTest(String id, String txt) {
            this.id = id;
            this.txt = txt;
        }

        @SpaceId
        @SpaceRouting
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }
    }



}

