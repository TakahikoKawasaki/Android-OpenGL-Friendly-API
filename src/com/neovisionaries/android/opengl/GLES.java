/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl;


import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;


/**
 * OpenGL ES interface.
 *
 * <p>
 * An implementation of this interface can be obtained by
 * {@link GLESFactory#getInstance()}.
 * </p>
 *
 * @author Takahiko Kawasaki
 *
 * @see GLESFactory#getInstance()
 */
public interface GLES
{
    int GL_ACTIVE_ATTRIBUTES();
    int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH();
    int GL_ACTIVE_TEXTURE();
    int GL_ACTIVE_UNIFORMS();
    int GL_ACTIVE_UNIFORM_MAX_LENGTH();
    int GL_ADD_SIGNED();
    int GL_ALIASED_LINE_WIDTH_RANGE();
    int GL_ALIASED_POINT_SIZE_RANGE();
    int GL_ALPHA();
    int GL_ALPHA_BITS();
    int GL_ALPHA_SCALE();
    int GL_ALPHA_TEST_FUNC();
    int GL_ALPHA_TEST_REF();
    int GL_ALWAYS();
    int GL_ARRAY_BUFFER();
    int GL_ARRAY_BUFFER_BINDING();
    int GL_ATTACHED_SHADERS();
    int GL_BACK();
    int GL_BLEND();
    int GL_BLEND_COLOR();
    int GL_BLEND_DST();
    int GL_BLEND_DST_ALPHA();
    int GL_BLEND_DST_RGB();
    int GL_BLEND_EQUATION();
    int GL_BLEND_EQUATION_ALPHA();
    int GL_BLEND_EQUATION_RGB();
    int GL_BLEND_SRC();
    int GL_BLEND_SRC_ALPHA();
    int GL_BLEND_SRC_RGB();
    int GL_BLUE_BITS();
    int GL_BOOL();
    int GL_BOOL_VEC2();
    int GL_BOOL_VEC3();
    int GL_BOOL_VEC4();
    int GL_BUFFER_ACCESS();
    int GL_BUFFER_SIZE();
    int GL_BUFFER_USAGE();
    int GL_BYTE();
    int GL_CCW();
    int GL_CLAMP_TO_EDGE();
    int GL_CLIENT_ACTIVE_TEXTURE();
    int GL_CLIP_PLANE0();
    int GL_CLIP_PLANE1();
    int GL_CLIP_PLANE2();
    int GL_CLIP_PLANE3();
    int GL_CLIP_PLANE4();
    int GL_CLIP_PLANE5();
    int GL_COLOR_ARRAY_BUFFER_BINDING();
    int GL_COLOR_ARRAY_POINTER();
    int GL_COLOR_ARRAY_SIZE();
    int GL_COLOR_ARRAY_STRIDE();
    int GL_COLOR_ARRAY_TYPE();
    int GL_COLOR_ATTACHMENT0();
    int GL_COLOR_BUFFER_BIT();
    int GL_COLOR_CLEAR_VALUE();
    int GL_COLOR_WRITEMASK();
    int GL_COMBINE();
    int GL_COMBINE_ALPHA();
    int GL_COMBINE_RGB();
    int GL_COMPILE_STATUS();
    int GL_COMPRESSED_TEXTURE_FORMATS();
    int GL_CONSTANT();
    int GL_CONSTANT_ALPHA();
    int GL_CONSTANT_COLOR();
    int GL_COORD_REPLACE_OES();
    int GL_CULL_FACE();
    int GL_CULL_FACE_MODE();
    int GL_CURRENT_COLOR();
    int GL_CURRENT_NORMAL();
    int GL_CURRENT_PROGRAM();
    int GL_CURRENT_TEXTURE_COORDS();
    int GL_CURRENT_VERTEX_ATTRIB();
    int GL_CW();
    int GL_DECR();
    int GL_DECR_WRAP();
    int GL_DELETE_STATUS();
    int GL_DEPTH_ATTACHMENT();
    int GL_DEPTH_BITS();
    int GL_DEPTH_BUFFER_BIT();
    int GL_DEPTH_CLEAR_VALUE();
    int GL_DEPTH_COMPONENT();
    int GL_DEPTH_COMPONENT16();
    int GL_DEPTH_FUNC();
    int GL_DEPTH_RANGE();
    int GL_DEPTH_TEST();
    int GL_DEPTH_WRITEMASK();
    int GL_DITHER();
    int GL_DONT_CARE();
    int GL_DOT3_RGB();
    int GL_DOT3_RGBA();
    int GL_DST_ALPHA();
    int GL_DST_COLOR();
    int GL_DYNAMIC_DRAW();
    int GL_ELEMENT_ARRAY_BUFFER();
    int GL_ELEMENT_ARRAY_BUFFER_BINDING();
    int GL_EQUAL();
    int GL_EXTENSIONS();
    int GL_FALSE();
    int GL_FASTEST();
    int GL_FIXED();
    int GL_FLOAT();
    int GL_FLOAT_MAT2();
    int GL_FLOAT_MAT3();
    int GL_FLOAT_MAT4();
    int GL_FLOAT_VEC2();
    int GL_FLOAT_VEC3();
    int GL_FLOAT_VEC4();
    int GL_FRAGMENT_SHADER();
    int GL_FRAMEBUFFER();
    int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME();
    int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE();
    int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE();
    int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL();
    int GL_FRAMEBUFFER_BINDING();
    int GL_FRAMEBUFFER_COMPLETE();
    int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT();
    int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS();
    int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT();
    int GL_FRAMEBUFFER_UNSUPPORTED();
    int GL_FRONT();
    int GL_FRONT_AND_BACK();
    int GL_FRONT_FACE();
    int GL_FUNC_ADD();
    int GL_FUNC_REVERSE_SUBTRACT();
    int GL_FUNC_SUBTRACT();
    int GL_GENERATE_MIPMAP();
    int GL_GENERATE_MIPMAP_HINT();
    int GL_GEQUAL();
    int GL_GREATER();
    int GL_GREEN_BITS();
    int GL_HIGH_FLOAT();
    int GL_HIGH_INT();
    int GL_IMPLEMENTATION_COLOR_READ_FORMAT();
    int GL_IMPLEMENTATION_COLOR_READ_TYPE();
    int GL_INCR();
    int GL_INCR_WRAP();
    int GL_INFO_LOG_LENGTH();
    int GL_INT();
    int GL_INTERPOLATE();
    int GL_INT_VEC2();
    int GL_INT_VEC3();
    int GL_INT_VEC4();
    int GL_INVALID_ENUM();
    int GL_INVALID_FRAMEBUFFER_OPERATION();
    int GL_INVALID_OPERATION();
    int GL_INVALID_VALUE();
    int GL_INVERT();
    int GL_KEEP();
    int GL_LEQUAL();
    int GL_LESS();
    int GL_LINEAR();
    int GL_LINEAR_MIPMAP_LINEAR();
    int GL_LINEAR_MIPMAP_NEAREST();
    int GL_LINES();
    int GL_LINE_LOOP();
    int GL_LINE_STRIP();
    int GL_LINE_WIDTH();
    int GL_LINK_STATUS();
    int GL_LOGIC_OP_MODE();
    int GL_LOW_FLOAT();
    int GL_LOW_INT();
    int GL_LUMINANCE();
    int GL_LUMINANCE_ALPHA();
    int GL_MATRIX_MODE();
    int GL_MAX_CLIP_PLANES();
    int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS();
    int GL_MAX_CUBE_MAP_TEXTURE_SIZE();
    int GL_MAX_FRAGMENT_UNIFORM_VECTORS();
    int GL_MAX_RENDERBUFFER_SIZE();
    int GL_MAX_TEXTURE_IMAGE_UNITS();
    int GL_MAX_TEXTURE_SIZE();
    int GL_MAX_VARYING_VECTORS();
    int GL_MAX_VERTEX_ATTRIBS();
    int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS();
    int GL_MAX_VERTEX_UNIFORM_VECTORS();
    int GL_MAX_VIEWPORT_DIMS();
    int GL_MEDIUM_FLOAT();
    int GL_MEDIUM_INT();
    int GL_MIRRORED_REPEAT();
    int GL_MODELVIEW_MATRIX();
    int GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES();
    int GL_MODELVIEW_STACK_DEPTH();
    int GL_NEAREST();
    int GL_NEAREST_MIPMAP_LINEAR();
    int GL_NEAREST_MIPMAP_NEAREST();
    int GL_NEVER();
    int GL_NICEST();
    int GL_NONE();
    int GL_NORMAL_ARRAY_POINTER();
    int GL_NORMAL_ARRAY_STRIDE();
    int GL_NORMAL_ARRAY_TYPE();
    int GL_NOTEQUAL();
    int GL_NO_ERROR();
    int GL_NUM_COMPRESSED_TEXTURE_FORMATS();
    int GL_NUM_SHADER_BINARY_FORMATS();
    int GL_ONE();
    int GL_ONE_MINUS_CONSTANT_ALPHA();
    int GL_ONE_MINUS_CONSTANT_COLOR();
    int GL_ONE_MINUS_DST_ALPHA();
    int GL_ONE_MINUS_DST_COLOR();
    int GL_ONE_MINUS_SRC_ALPHA();
    int GL_ONE_MINUS_SRC_COLOR();
    int GL_OPERAND0_ALPHA();
    int GL_OPERAND0_RGB();
    int GL_OPERAND1_ALPHA();
    int GL_OPERAND1_RGB();
    int GL_OPERAND2_ALPHA();
    int GL_OPERAND2_RGB();
    int GL_OUT_OF_MEMORY();
    int GL_PACK_ALIGNMENT();
    int GL_POINTS();
    int GL_POINT_DISTANCE_ATTENUATION();
    int GL_POINT_FADE_THRESHOLD_SIZE();
    int GL_POINT_SIZE();
    int GL_POINT_SIZE_ARRAY_BUFFER_BINDING_OES();
    int GL_POINT_SIZE_ARRAY_OES();
    int GL_POINT_SIZE_ARRAY_POINTER_OES();
    int GL_POINT_SIZE_ARRAY_STRIDE_OES();
    int GL_POINT_SIZE_ARRAY_TYPE_OES();
    int GL_POINT_SIZE_MAX();
    int GL_POINT_SIZE_MIN();
    int GL_POINT_SPRITE_OES();
    int GL_POLYGON_OFFSET_FACTOR();
    int GL_POLYGON_OFFSET_FILL();
    int GL_POLYGON_OFFSET_UNITS();
    int GL_PREVIOUS();
    int GL_PRIMARY_COLOR();
    int GL_PROJECTION_MATRIX();
    int GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES();
    int GL_PROJECTION_STACK_DEPTH();
    int GL_RED_BITS();
    int GL_RENDERBUFFER();
    int GL_RENDERBUFFER_ALPHA_SIZE();
    int GL_RENDERBUFFER_BINDING();
    int GL_RENDERBUFFER_BLUE_SIZE();
    int GL_RENDERBUFFER_DEPTH_SIZE();
    int GL_RENDERBUFFER_GREEN_SIZE();
    int GL_RENDERBUFFER_HEIGHT();
    int GL_RENDERBUFFER_INTERNAL_FORMAT();
    int GL_RENDERBUFFER_RED_SIZE();
    int GL_RENDERBUFFER_STENCIL_SIZE();
    int GL_RENDERBUFFER_WIDTH();
    int GL_RENDERER();
    int GL_REPEAT();
    int GL_REPLACE();
    int GL_RGB();
    int GL_RGB565();
    int GL_RGB5_A1();
    int GL_RGBA();
    int GL_RGBA4();
    int GL_RGB_SCALE();
    int GL_SAMPLER_2D();
    int GL_SAMPLER_CUBE();
    int GL_SAMPLES();
    int GL_SAMPLE_ALPHA_TO_COVERAGE();
    int GL_SAMPLE_BUFFERS();
    int GL_SAMPLE_COVERAGE();
    int GL_SAMPLE_COVERAGE_INVERT();
    int GL_SAMPLE_COVERAGE_VALUE();
    int GL_SCISSOR_BOX();
    int GL_SCISSOR_TEST();
    int GL_SHADER_BINARY_FORMATS();
    int GL_SHADER_COMPILER();
    int GL_SHADER_SOURCE_LENGTH();
    int GL_SHADER_TYPE();
    int GL_SHADE_MODEL();
    int GL_SHADING_LANGUAGE_VERSION();
    int GL_SHORT();
    int GL_SRC0_ALPHA();
    int GL_SRC0_RGB();
    int GL_SRC1_ALPHA();
    int GL_SRC1_RGB();
    int GL_SRC2_ALPHA();
    int GL_SRC2_RGB();
    int GL_SRC_ALPHA();
    int GL_SRC_ALPHA_SATURATE();
    int GL_SRC_COLOR();
    int GL_STATIC_DRAW();
    int GL_STENCIL_ATTACHMENT();
    int GL_STENCIL_BACK_FAIL();
    int GL_STENCIL_BACK_FUNC();
    int GL_STENCIL_BACK_PASS_DEPTH_FAIL();
    int GL_STENCIL_BACK_PASS_DEPTH_PASS();
    int GL_STENCIL_BACK_REF();
    int GL_STENCIL_BACK_VALUE_MASK();
    int GL_STENCIL_BACK_WRITEMASK();
    int GL_STENCIL_BITS();
    int GL_STENCIL_BUFFER_BIT();
    int GL_STENCIL_CLEAR_VALUE();
    int GL_STENCIL_FAIL();
    int GL_STENCIL_FUNC();
    int GL_STENCIL_INDEX();
    int GL_STENCIL_INDEX8();
    int GL_STENCIL_PASS_DEPTH_FAIL();
    int GL_STENCIL_PASS_DEPTH_PASS();
    int GL_STENCIL_REF();
    int GL_STENCIL_TEST();
    int GL_STENCIL_VALUE_MASK();
    int GL_STENCIL_WRITEMASK();
    int GL_STREAM_DRAW();
    int GL_SUBPIXEL_BITS();
    int GL_SUBTRACT();
    int GL_TEXTURE();
    int GL_TEXTURE0();
    int GL_TEXTURE1();
    int GL_TEXTURE2();
    int GL_TEXTURE3();
    int GL_TEXTURE4();
    int GL_TEXTURE5();
    int GL_TEXTURE6();
    int GL_TEXTURE7();
    int GL_TEXTURE8();
    int GL_TEXTURE9();
    int GL_TEXTURE10();
    int GL_TEXTURE11();
    int GL_TEXTURE12();
    int GL_TEXTURE13();
    int GL_TEXTURE14();
    int GL_TEXTURE15();
    int GL_TEXTURE16();
    int GL_TEXTURE17();
    int GL_TEXTURE18();
    int GL_TEXTURE19();
    int GL_TEXTURE20();
    int GL_TEXTURE21();
    int GL_TEXTURE22();
    int GL_TEXTURE23();
    int GL_TEXTURE24();
    int GL_TEXTURE25();
    int GL_TEXTURE26();
    int GL_TEXTURE27();
    int GL_TEXTURE28();
    int GL_TEXTURE29();
    int GL_TEXTURE30();
    int GL_TEXTURE31();
    int GL_TEXTURE_2D();
    int GL_TEXTURE_BINDING_2D();
    int GL_TEXTURE_BINDING_CUBE_MAP();
    int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING();
    int GL_TEXTURE_COORD_ARRAY_POINTER();
    int GL_TEXTURE_COORD_ARRAY_SIZE();
    int GL_TEXTURE_COORD_ARRAY_STRIDE();
    int GL_TEXTURE_COORD_ARRAY_TYPE();
    int GL_TEXTURE_CUBE_MAP();
    int GL_TEXTURE_CUBE_MAP_NEGATIVE_X();
    int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y();
    int GL_TEXTURE_CUTE_MAP_NEGATIVE_Z();
    int GL_TEXTURE_CUBE_MAP_POSITIVE_X();
    int GL_TEXTURE_CUBE_MAP_POSITIVE_Y();
    int GL_TEXTURE_CUBE_MAP_POSITIVE_Z();
    int GL_TEXTURE_MAG_FILTER();
    int GL_TEXTURE_MATRIX();
    int GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES();
    int GL_TEXTURE_MIN_FILTER();
    int GL_TEXTURE_STACK_DEPTH();
    int GL_TEXTURE_WRAP_S();
    int GL_TEXTURE_WRAP_T();
    int GL_TRIANGLES();
    int GL_TRIANGLE_FAN();
    int GL_TRIANGLE_STRIP();
    int GL_TRUE();
    int GL_UNPACK_ALIGNMENT();
    int GL_UNSIGNED_BYTE();
    int GL_UNSIGNED_INT();
    int GL_UNSIGNED_SHORT();
    int GL_UNSIGNED_SHORT_4_4_4_4();
    int GL_UNSIGNED_SHORT_5_5_5_1();
    int GL_UNSIGNED_SHORT_5_6_5();
    int GL_VALIDATE_STATUS();
    int GL_VENDOR();
    int GL_VERSION();
    int GL_VERTEX_ARRAY_BUFFER_BINDING();
    int GL_VERTEX_ARRAY_POINTER();
    int GL_VERTEX_ARRAY_SIZE();
    int GL_VERTEX_ARRAY_STRIDE();
    int GL_VERTEX_ARRAY_TYPE();
    int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING();
    int GL_VERTEX_ATTRIB_ARRAY_ENABLED();
    int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED();
    int GL_VERTEX_ATTRIB_ARRAY_POINTER();
    int GL_VERTEX_ATTRIB_ARRAY_SIZE();
    int GL_VERTEX_ATTRIB_ARRAY_STRIDE();
    int GL_VERTEX_ATTRIB_ARRAY_TYPE();
    int GL_VERTEX_SHADER();
    int GL_VIEWPORT();
    int GL_WRITE_ONLY();
    int GL_ZERO();


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glAttachShader.xml">glAttachShader</a>
     */
    void glAttachShader(int programId, int shaderId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindAttribLocation.xml">glBindAttribLocation</a>
     */
    void glBindAttribLocation(int programId, int attributeIndex, String attributeName);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBindBuffer.xml">glBindBuffer</a>
     */
    void glBindBuffer(int vertexBufferType, int vertexBufferId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBufferData.xml">glBufferData</a>
     */
    void glBufferData(int vertexBufferType, int size, Buffer data, int vertexBufferUsage);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glBufferData.xml">glBufferSubData</a>
     */
    void glBufferSubData(int vertexBufferType, int offset, int size, Buffer data);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClear.xml">glClear</a>
     */
    void glClear(int mask);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClearColor.xml">glClearColor</a>
     */
    void glClearColor(float red, float green, float blue, float alpha);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClearDepthf.xml">glClearDepthf</a>
     */
    void glClearDepthf(float depth);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glClearStencil.xml">glClearStencil</a>
     */
    void glClearStencil(int stencil);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCompileShader.xml">glCompileShader</a>
     */
    void glCompileShader(int shaderId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCreateProgram.xml">glCreateProgram</a>
     */
    int glCreateProgram();


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glCreateShader.xml">glCreateShader</a>
     */
    int glCreateShader(int shaderType);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDeleteBuffers.xml">glDeleteBuffers</a>
     */
    void glDeleteBuffers(int vertexBufferType, int[] vertexBufferIds, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDeleteProgram.xml">glDeleteProgram</a>
     */
    void glDeleteProgram(int programId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDeleteShader.xml">glDeleteShader</a>
     */
    void glDeleteShader(int shaderId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisable.xml">glDisable</a>
     */
    void glDisable(int capability);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDisableVertexAttribArray.xml">glDisableVertexAttribArray</a>
     */
    void glDisableVertexAttribArray(int index);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDetachShader.xml">glDetachShader</a>
     */
    void glDetachShader(int programId, int shaderId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDrawArrays.xml">glDrawArrays</a>
     */
    void glDrawArrays(int mode, int first, int count);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDrawElements.xml">glDrawElements</a>
     */
    void glDrawElements(int mode, int count, int type, Buffer indices);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glDrawElements.xml">glDrawElements</a>
     */
    void glDrawElements(int mode, int count, int type, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glEnable.xml">glEnable</a>
     */
    void glEnable(int capability);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glEnableVertexAttribArray.xml">glEnableVertexAttribArray</a>
     */
    void glEnableVertexAttribArray(int index);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glFinish.xml">glFinish</a>
     */
    void glFinish();


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glFlush.xml">glFlush</a>
     */
    void glFlush();


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGenBuffers.xml">glGenBuffers</a>
     */
    void glGenBuffers(int vertexBufferType, int[] vertexBufferIds, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetAttribLocation.xml">glGetAttribLocation</a>
     */
    int glGetAttribLocation(int programId, String attributeName);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGet.xml">glGetBooleanv</a>
     */
    void glGetBooleanv(int parameterId, IntBuffer params);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGet.xml">glGetBooleanv</a>
     */
    void glGetBooleanv(int parameterId, boolean[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetError.xml">glGetError</a>
     */
    int glGetError();


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGet.xml">glGetFloatv</a>
     */
    void glGetFloatv(int parameterId, FloatBuffer params);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGet.xml">glGetFloatv</a>
     */
    void glGetFloatv(int parameterId, float[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGet.xml">glGetIntegerv</a>
     */
    void glGetIntegerv(int parameterId, IntBuffer params);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGet.xml">glGetIntegerv</a>
     */
    void glGetIntegerv(int parameterId, int[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetProgramInfoLog.xml">glGetProgramInfoLog</a>
     */
    String glGetProgramInfoLog(int programId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetProgramiv.xml">glGetProgramiv</a>
     */
    void glGetProgramiv(int programId, int parameterId, int[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetShaderInfoLog.xml">glGetShaderInfoLog</a>
     */
    String glGetShaderInfoLog(int shaderId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetShaderiv.xml">glGetShaderiv</a>
     */
    void glGetShaderiv(int shaderId, int parameterId, int[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetString.xml">glGettring</a>
     */
    String glGetString(int parameterId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformfv</a>
     */
    void glGetUniformfv(int programId, int uniformLocation, FloatBuffer params);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformfv</a>
     */
    void glGetUniformfv(int programId, int uniformLocation, float[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformiv</a>
     */
    void glGetUniformiv(int programId, int uniformLocation, IntBuffer params);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniform.xml">glGetUniformiv</a>
     */
    void glGetUniformiv(int programId, int uniformLocation, int[] params, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glGetUniformLocation.xml">glGetUniformLocation</a>
     */
    int glGetUniformLocation(int programId, String variableName);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glIsEnabled.xml">glIsEnabled</a>
     */
    boolean glIsEnabled(int capability);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glLinkProgram.xml">glLinkProgram</a>
     */
    void glLinkProgram(int programId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glReleaseShaderCompiler.xml">glReleaseShaderCompiler</a>
     */
    void glReleaseShaderCompiler();


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glShaderSource.xml">glShaderSource</a>
     */
    void glShaderSource(int shaderId, String shaderSourceCode);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1f</a>
     */
    void glUniform1f(int uniformLocation, float x);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1fv</a>
     */
    void glUniform1fv(int uniformLocation, int count, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1fv</a>
     */
    void glUniform1fv(int uniformLocation, int count, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1i</a>
     */
    void glUniform1i(int uniformLocation, int x);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1iv</a>
     */
    void glUniform1iv(int uniformLocation, int count, IntBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform1iv</a>
     */
    void glUniform1iv(int uniformLocation, int count, int[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2f</a>
     */
    void glUniform2f(int uniformLocation, float x, float y);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2fv</a>
     */
    void glUniform2fv(int uniformLocation, int count, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2fv</a>
     */
    void glUniform2fv(int uniformLocation, int count, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2i</a>
     */
    void glUniform2i(int uniformLocation, int x, int y);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2iv</a>
     */
    void glUniform2iv(int uniformLocation, int count, IntBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform2iv</a>
     */
    void glUniform2iv(int uniformLocation, int count, int[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3f</a>
     */
    void glUniform3f(int uniformLocation, float x, float y, float z);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3fv</a>
     */
    void glUniform3fv(int uniformLocation, int count, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3fv</a>
     */
    void glUniform3fv(int uniformLocation, int count, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3i</a>
     */
    void glUniform3i(int uniformLocation, int x, int y, int z);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3iv</a>
     */
    void glUniform3iv(int uniformLocation, int count, IntBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform3iv</a>
     */
    void glUniform3iv(int uniformLocation, int count, int[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4f</a>
     */
    void glUniform4f(int uniformLocation, float x, float y, float z, float w);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4fv</a>
     */
    void glUniform4fv(int uniformLocation, int count, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4fv</a>
     */
    void glUniform4fv(int uniformLocation, int count, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4i</a>
     */
    void glUniform4i(int uniformLocation, int x, int y, int z, int w);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4iv</a>
     */
    void glUniform4iv(int uniformLocation, int count, IntBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniform4iv</a>
     */
    void glUniform4iv(int uniformLocation, int count, int[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix2fv</a>
     */
    void glUniformMatrix2fv(int uniformLocation, int count, boolean transpose, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix2fv</a>
     */
    void glUniformMatrix2fv(int uniformLocation, int count, boolean transpose, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix3fv</a>
     */
    void glUniformMatrix3fv(int uniformLocation, int count, boolean transpose, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix3fv</a>
     */
    void glUniformMatrix3fv(int uniformLocation, int count, boolean transpose, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix4fv</a>
     */
    void glUniformMatrix4fv(int uniformLocation, int count, boolean transpose, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUniform.xml">glUniformMatrix4fv</a>
     */
    void glUniformMatrix4fv(int uniformLocation, int count, boolean transpose, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glUseProgram.xml">glUseProgram</a>
     */
    void glUseProgram(int programId);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib1f</a>
     */
    void glVertexAttrib1f(int vertexAttributeIndex, float x);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib1fv</a>
     */
    void glVertexAttrib1fv(int vertexAttributeIndex, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib1fv</a>
     */
    void glVertexAttrib1fv(int vertexAttributeIndex, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib2f</a>
     */
    void glVertexAttrib2f(int vertexAttributeIndex, float x, float y);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib2fv</a>
     */
    void glVertexAttrib2fv(int vertexAttributeIndex, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib2fv</a>
     */
    void glVertexAttrib2fv(int vertexAttributeIndex, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib3f</a>
     */
    void glVertexAttrib3f(int vertexAttributeIndex, float x, float y, float z);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib3fv</a>
     */
    void glVertexAttrib3fv(int vertexAttributeIndex, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib3fv</a>
     */
    void glVertexAttrib3fv(int vertexAttributeIndex, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib4f</a>
     */
    void glVertexAttrib4f(int vertexAttributeIndex, float x, float y, float z, float w);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib4fv</a>
     */
    void glVertexAttrib4fv(int vertexAttributeIndex, FloatBuffer values);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttrib.xml">glVertexAttrib4fv</a>
     */
    void glVertexAttrib4fv(int vertexAttributeIndex, float[] values, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttribPointer.xml">glVertexAttribPointer</a>
     */
    void glVertexAttribPointer(int vertexAttributeIndex, int size, int type, boolean normalized, int stride, Buffer ptr);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glVertexAttribPointer.xml">glVertexAttribPointer</a>
     */
    void glVertexAttribPointer(int vertexAttributeIndex, int size, int type, boolean normalized, int stride, int offset);


    /**
     * <a href="http://www.khronos.org/opengles/sdk/docs/man/xhtml/glViewport.xml">glViewport</a>
     */
    void glViewport(int x, int y, int width, int height);
}
