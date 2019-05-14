# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

#添加对jniLibs下的文件引用
include_directories(
        src/main/include/
)
#配置cpp文件
SET(SRC_LIST
        src/main/cpp/CarSpeed.cpp
        )

#配置库文件
SET(LIB_LIST
        ${log-lib}
        )

#生成静态库
add_library( # Sets the name of the library.
        #库命名
        static-lib
        # Sets the library as a static library.
        STATIC
        # Provides a relative path to your source file(s).
        ${SRC_LIST}
        )
SET_TARGET_PROPERTIES(static-lib PROPERTIES OUTPUT_NAME "hyapi_carspeed")

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library(
        # Sets the name of the path variable.
        log-lib
        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries(
        # Specifies the target library.
        static-lib
        # Links the target library to the log library
        # included in the NDK.
        ${LIB_LIST}
)

add_definitions(
        -DDEBUG_LOG
)