package com.sps;


import java.io.InputStream;

import java.net.URL;

import java.security.KeyStore;

import java.security.cert.Certificate;

import java.util.Enumeration;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;


public class Tester {
    public Tester() {
        super();
    }

    public static void main(String[] args) throws Exception {

        // Primero cargamos el Keystore de Windows
        //KeyStore ks = KeyStore.getInstance("Windows-MY");
        KeyStore ks = KeyStore.getInstance("WINDOWS-ROOT");
        ks.load(null, null);

        //Listamos lo que haya en el keystore
        Enumeration en = ks.aliases();
        while (en.hasMoreElements()) {
            String aliasKey = (String) en.nextElement();
            Certificate c = ks.getCertificate(aliasKey);
            System.out.println("---> alias : " + aliasKey);
            if (ks.isKeyEntry(aliasKey)) {
                Certificate[] chain = ks.getCertificateChain(aliasKey);
                System.out.println("---> tamano de la cadena: " + chain.length);
                for (Certificate cert : chain) {
                    System.out.println(cert);
                }
            }
        }
        
        // Le decimos a la clase que use el keystore cargado
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ks);

        // Establecemos la conexión TLS hacia el servicio
        SSLContext context = SSLContext.getInstance("TLS");
        TrustManager[] trustManagers = tmf.getTrustManagers();
        context.init(null, trustManagers, null);
        SSLSocketFactory sf = context.getSocketFactory();
        //URL url = new URL("https://www.google.com");
        URL url = new URL("https://www.facebook.com");
        //URL url = new URL("https://oke.rcarrascogb.com:8084/auth");

        HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();
        httpsCon.setSSLSocketFactory(sf);
        httpsCon.setRequestMethod("GET");

       /* InputStream inStrm = httpsCon.getInputStream();
            System.out.println("\nContenido " + url);
            int ch;
              while (((ch = inStrm.read()) != -1)){
                System.out.print((char) ch);
              inStrm.close();
            }*/

        System.out.println("Mensaje de respuesta: " + httpsCon.getResponseMessage() + ". HTTP Response Code: " + httpsCon.getResponseCode());
        System.out.println("Content-Type: " + httpsCon.getHeaderField("Content-Type"));
        

    }
}
