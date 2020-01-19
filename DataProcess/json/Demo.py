#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_Demo.py
@author:    ziv
@time:      2020/1/8
@version:   v1.0.0
@desc:      json解析
"""

import json
import re
import os

auto_import_server = """
import android.util.Log;

import com.ziv.demo.netcheck.utils.network.HttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author ziv
 */
"""

auto_import_api = """
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author ziv
 */
"""

TYPE_SERVER = "Server"
TYPE_API = "Api"


class Util:
    def __init__(self):
        self.pos = 0
        self.host = []
        self.type = ""
        self.domain = {}
        self.url = {}

    def parse_url(self, json_data):
        if isinstance(json_data, dict):
            json_object = json_data.items()
            for key, value in json_object:
                # print(self.pos, key, value)
                if key == "hosts":
                    self.parse_url(value)
                    continue
                self.url[key] = value
                # print(key, value)

        elif isinstance(json_data, list):
            self.host = json_data
        # else:
            # print(self.pos, json_data)
            # value_file.write(json_data + "\n")
            # self.write_to_file(json_data)

    def parse_host(self):
        self.pos += 1
        for item in self.host:
            if isinstance(item, dict):
                json_object = item.items()
                for key, value in json_object:
                    # print(key, value)
                    if key == "type":
                        self.type = value
                    if isinstance(value, list):
                        for domains in value:
                            if isinstance(domains, dict):
                                for key_domain, value_domain in domains.items():
                                    # print(key_domain, value_domain)
                                    if key_domain == "domain":
                                        self.domain.setdefault(self.type, []).append(value_domain)
        # print(self.domain)
        self.pos -= 1

    def create_dirs(self):
        print(self.url)
        for key, value in self.url.items():
            dirs = re.findall(r"host:(\w+)", value)[0]
            # 创建目录
            os.makedirs(dirs, exist_ok=True)

    def save_header(self, class_type):
        print("save header")
        for key, value in self.url.items():
            dirs = re.findall(r"host:(\w+)", value)[0]
            host_name = dirs.capitalize()
            class_name = host_name + class_type
            file_name = dirs + "/" + class_name + ".java"
            print(file_name)

            # 文件不存在返回False: 创建写(单纯只写HOST及以上内容), 存在True则跳过
            if not os.path.isfile(file_name):
                with open(file_name, "a+") as wf:
                    wf.write("package com.ziv.demo.netcheck." + dirs + ";\n")
                    if class_type == TYPE_SERVER:
                        wf.write(auto_import_server)
                        wf.write("public class " + class_name + "{\n")
                        wf.write("    private static final String TAG = \"" + class_name + "\";\n")
                        index = 0
                        domains = ''
                        for domain in self.domain[dirs]:
                            index = index + 1
                            domains = domains + "\"" + domain + "\""
                            if len(self.domain[dirs]) != index:
                                domains = domains + ", "
                        wf.write("    public static final ArrayList<String> HOST_" + host_name.upper() + "_LIST = new ArrayList<>(Arrays.asList(" + domains + "));\n")

                    elif class_type == TYPE_API:
                        wf.write(auto_import_api)
                        wf.write("public interface " + class_name + "{\n")

    def save_body_urls(self, class_type):
        print("save body urls")
        print(self.host)
        for key, value in self.url.items():
            dirs = re.findall(r"host:(\w+)", value)[0]
            host_name = dirs.capitalize()
            server_name = host_name + TYPE_SERVER
            api_name = host_name + class_type
            server_file_name = dirs + "/" + api_name + ".java"
            print(server_file_name)
            url = re.findall(r"http://{\w+:\w+}/(.+)", value)
            with open(server_file_name, "a+") as wf:
                if len(url) > 0:
                    url = url[0]
                else:
                    url = ""
                # wf.write("    @GET(" + server_name + "." + key.upper() + ")\n")
                # wf.write("    Call<ResponseBody>" + server_name + "." + key.upper() + ")\n")
                wf.write("    public static final String URL_" + key.upper() + " = \"" + url + "\";\n")

    def save_foot(self):
        print("save foot")
        print(self.host)
        for key, value in self.url.items():
            dirs = re.findall(r"host:(\w+)", value)[0]
            host_name = dirs.capitalize()
            class_name = host_name + "Server"
            file_name = dirs + "/" + class_name + ".java"
            print(file_name)
            # 判断文件是否有修改
            if os.path.isfile(file_name):
                with open(file_name, "a+") as wf:
                    for domain in self.domain[dirs]:
                        wf.write()

    def create_server_file(self, json_data):
        self.parse_url(json_data)
        self.parse_host()
        self.create_dirs()
        self.save_header(TYPE_SERVER)
        self.save_body_urls(TYPE_SERVER)

    def create_api_file(self, json_data):
        self.parse_url(json_data)
        self.parse_host()
        self.create_dirs()
        self.save_header(TYPE_API)
        self.save_body_urls(TYPE_API)


if __name__ == "__main__":
    with open('api_config.json', 'r') as f:
        file_data = json.load(f)
        util = Util()
        util.create_server_file(file_data)
        # util.create_api_file(file_data)


'''
json.dumps: 对数据进行编码
json.loads(json_data): 对数据进行解码
json.load(f)
'''