/*
 * (C) 2012 Neo Visionaries Inc. All Rights Reserved.
 */
package com.neovisionaries.android.opengl.impl;


import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import com.neovisionaries.android.opengl.GLES;


/**
 * The base implementation of {@link GLES} interface.
 * 
 * <ol>
 * <li>All gl* methods throw UnsupportedOperationException.
 * <li>All GL_* methods return appropriate values.
 * </ol>
 * 
 * @author Takahiko Kawasaki
 */
public abstract class GLESImplBase implements GLES
{
    protected GLESImplBase()
    {
    }


    @Override
    public int GL_ACTIVE_ATTRIBUTES()
    {
        return 0x00008b89;
    }


    @Override
    public int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH()
    {
        return 0x00008b8a;
    }


    @Override
    public int GL_ACTIVE_TEXTURE()
    {
        return 0x000084e0;
    }


    @Override
    public int GL_ACTIVE_UNIFORMS()
    {
        return 0x00008b86;
    }


    @Override
    public int GL_ACTIVE_UNIFORM_MAX_LENGTH()
    {
        return 0x00008b87;
    }


    @Override
    public int GL_ADD_SIGNED()
    {
        return 0x00008574;
    }


    @Override
    public int GL_ALIASED_LINE_WIDTH_RANGE()
    {
        return 0x0000846e;
    }


    @Override
    public int GL_ALIASED_POINT_SIZE_RANGE()
    {
        return 0x0000846d;
    }


    @Override
    public int GL_ALPHA()
    {
        return 0x00001906;
    }


    @Override
    public int GL_ALPHA_BITS()
    {
        return 0x00000d55;
    }


    @Override
    public int GL_ALPHA_SCALE()
    {
        return 0x00000d1c;
    }


    @Override
    public int GL_ALPHA_TEST_FUNC()
    {
        return 0x00000bc1;
    }


    @Override
    public int GL_ALPHA_TEST_REF()
    {
        return 0x00000bc2;
    }


    @Override
    public int GL_ALWAYS()
    {
        return 0x00000207;
    }


    @Override
    public int GL_ARRAY_BUFFER()
    {
        return 0x00008892;
    }


    @Override
    public int GL_ARRAY_BUFFER_BINDING()
    {
        return 0x00008894;
    }


    @Override
    public int GL_ATTACHED_SHADERS()
    {
        return 0x00008b85;
    }


    @Override
    public int GL_BACK()
    {
        return 0x00000405;
    }


    @Override
    public int GL_BLEND()
    {
        return 0x00000be2;
    }


    @Override
    public int GL_BLEND_COLOR()
    {
        return 0x00008005;
    }


    @Override
    public int GL_BLEND_DST()
    {
        return 0x00000be0;
    }


    @Override
    public int GL_BLEND_DST_ALPHA()
    {
        return 0x000080ca;
    }


    @Override
    public int GL_BLEND_DST_RGB()
    {
        return 0x000080c8;
    }


    @Override
    public int GL_BLEND_EQUATION()
    {
        return 0x00008009;
    }


    @Override
    public int GL_BLEND_EQUATION_ALPHA()
    {
        return 0x0000883d;
    }


    @Override
    public int GL_BLEND_EQUATION_RGB()
    {
        return 0x00008009;
    }


    @Override
    public int GL_BLEND_SRC()
    {
        return 0x00000be1;
    }


    @Override
    public int GL_BLEND_SRC_ALPHA()
    {
        return 0x000080cb;
    }


    @Override
    public int GL_BLEND_SRC_RGB()
    {
        return 0x000080c9;
    }


    @Override
    public int GL_BLUE_BITS()
    {
        return 0x00000d54;
    }


    @Override
    public int GL_BOOL()
    {
        return 0x00008b56;
    }


    @Override
    public int GL_BOOL_VEC2()
    {
        return 0x00008b57;
    }


    @Override
    public int GL_BOOL_VEC3()
    {
        return 0x00008b58;
    }


    @Override
    public int GL_BOOL_VEC4()
    {
        return 0x00008b59;
    }


    @Override
    public int GL_BUFFER_ACCESS()
    {
        return 0x000088bb;
    }


    @Override
    public int GL_BUFFER_SIZE()
    {
        return 0x00008764;
    }


    @Override
    public int GL_BUFFER_USAGE()
    {
        return 0x00008765;
    }


    @Override
    public int GL_BYTE()
    {
        return 0x00001400;
    }


    @Override
    public int GL_CCW()
    {
        return 0x00000901;
    }


    @Override
    public int GL_CLAMP_TO_EDGE()
    {
        return 0x0000812f;
    }


    @Override
    public int GL_CLIENT_ACTIVE_TEXTURE()
    {
        return 0x000084e1;
    }


    @Override
    public int GL_CLIP_PLANE0()
    {
        return 0x00003000;
    }


    @Override
    public int GL_CLIP_PLANE1()
    {
        return 0x00003001;
    }


    @Override
    public int GL_CLIP_PLANE2()
    {
        return 0x00003002;
    }


    @Override
    public int GL_CLIP_PLANE3()
    {
        return 0x00003003;
    }


    @Override
    public int GL_CLIP_PLANE4()
    {
        return 0x00003004;
    }


    @Override
    public int GL_CLIP_PLANE5()
    {
        return 0x00003005;
    }


    @Override
    public int GL_COLOR_ARRAY_BUFFER_BINDING()
    {
        return 0x00008898;
    }


    @Override
    public int GL_COLOR_ARRAY_POINTER()
    {
        return 0x00008090;
    }


    @Override
    public int GL_COLOR_ARRAY_SIZE()
    {
        return 0x00008081;
    }


    @Override
    public int GL_COLOR_ARRAY_STRIDE()
    {
        return 0x00008083;
    }


    @Override
    public int GL_COLOR_ARRAY_TYPE()
    {
        return 0x00008082;
    }


    @Override
    public int GL_COLOR_ATTACHMENT0()
    {
        return 0x00008ce0;
    }


    @Override
    public int GL_COLOR_BUFFER_BIT()
    {
        return 0x00004000;
    }


    @Override
    public int GL_COLOR_CLEAR_VALUE()
    {
        return 0x00000c22;
    }


    @Override
    public int GL_COLOR_WRITEMASK()
    {
        return 0x00000c23;
    }


    @Override
    public int GL_COMBINE()
    {
        return 0x00008570;
    }


    @Override
    public int GL_COMBINE_ALPHA()
    {
        return 0x00008572;
    }


    @Override
    public int GL_COMBINE_RGB()
    {
        return 0x00008571;
    }


    @Override
    public int GL_COMPILE_STATUS()
    {
        return 0x00008b81;
    }


    @Override
    public int GL_COMPRESSED_TEXTURE_FORMATS()
    {
        return 0x000086a3;
    }


    @Override
    public int GL_CONSTANT()
    {
        return 0x00008576;
    }


    @Override
    public int GL_CONSTANT_ALPHA()
    {
        return 0x00008003;
    }


    @Override
    public int GL_CONSTANT_COLOR()
    {
        return 0x00008001;
    }


    @Override
    public int GL_COORD_REPLACE_OES()
    {
        return 0x00008862;
    }


    @Override
    public int GL_CULL_FACE()
    {
        return 0x00000b44;
    }


    @Override
    public int GL_CULL_FACE_MODE()
    {
        return 0x00000b45;
    }


    @Override
    public int GL_CURRENT_COLOR()
    {
        return 0x00000b00;
    }


    @Override
    public int GL_CURRENT_NORMAL()
    {
        return 0x00000b02;
    }


    @Override
    public int GL_CURRENT_PROGRAM()
    {
        return 0x00008b8d;
    }


    @Override
    public int GL_CURRENT_TEXTURE_COORDS()
    {
        return 0x00000b03;
    }


    @Override
    public int GL_CURRENT_VERTEX_ATTRIB()
    {
        return 0x00008626;
    }


    @Override
    public int GL_CW()
    {
        return 0x00000900;
    }


    @Override
    public int GL_DECR()
    {
        return 0x00001e03;
    }


    @Override
    public int GL_DECR_WRAP()
    {
        return 0x00008508;
    }


    @Override
    public int GL_DELETE_STATUS()
    {
        return 0x00008b80;
    }


    @Override
    public int GL_DEPTH_ATTACHMENT()
    {
        return 0x00008d00;
    }


    @Override
    public int GL_DEPTH_BITS()
    {
        return 0x00000d56;
    }


    @Override
    public int GL_DEPTH_BUFFER_BIT()
    {
        return 0x00000100;
    }


    @Override
    public int GL_DEPTH_CLEAR_VALUE()
    {
        return 0x00000b73;
    }


    @Override
    public int GL_DEPTH_COMPONENT()
    {
        return 0x00001902;
    }


    @Override
    public int GL_DEPTH_COMPONENT16()
    {
        return 0x000081a5;
    }


    @Override
    public int GL_DEPTH_FUNC()
    {
        return 0x00000b74;
    }


    @Override
    public int GL_DEPTH_RANGE()
    {
        return 0x00000b70;
    }


    @Override
    public int GL_DEPTH_TEST()
    {
        return 0x00000b71;
    }


    @Override
    public int GL_DEPTH_WRITEMASK()
    {
        return 0x00000b72;
    }


    @Override
    public int GL_DITHER()
    {
        return 0x00000bd0;
    }


    @Override
    public int GL_DONT_CARE()
    {
        return 0x00001100;
    }


    @Override
    public int GL_DOT3_RGB()
    {
        return 0x000086ae;
    }


    @Override
    public int GL_DOT3_RGBA()
    {
        return 0x000086af;
    }


    @Override
    public int GL_DST_ALPHA()
    {
        return 0x00000304;
    }


    @Override
    public int GL_DST_COLOR()
    {
        return 0x00000306;
    }


    @Override
    public int GL_DYNAMIC_DRAW()
    {
        return 0x000088e8;
    }


    @Override
    public int GL_ELEMENT_ARRAY_BUFFER()
    {
        return 0x00008893;
    }


    @Override
    public int GL_ELEMENT_ARRAY_BUFFER_BINDING()
    {
        return 0x00008895;
    }


    @Override
    public int GL_EQUAL()
    {
        return 0x00000202;
    }


    @Override
    public int GL_EXTENSIONS()
    {
        return 0x00001f03;
    }


    @Override
    public int GL_FALSE()
    {
        return 0;
    }


    @Override
    public int GL_FASTEST()
    {
        return 0x00001101;
    }


    @Override
    public int GL_FIXED()
    {
        return 0x0000140c;
    }


    @Override
    public int GL_FLOAT()
    {
        return 0x00001406;
    }


    @Override
    public int GL_FLOAT_MAT2()
    {
        return 0x00008b5a;
    }


    @Override
    public int GL_FLOAT_MAT3()
    {
        return 0x00008b5b;
    }


    @Override
    public int GL_FLOAT_MAT4()
    {
        return 0x00008b5c;
    }


    @Override
    public int GL_FLOAT_VEC2()
    {
        return 0x00008b50;
    }


    @Override
    public int GL_FLOAT_VEC3()
    {
        return 0x00008b51;
    }


    @Override
    public int GL_FLOAT_VEC4()
    {
        return 0x00008b52;
    }


    @Override
    public int GL_FRAGMENT_SHADER()
    {
        return 0x00008b30;
    }


    @Override
    public int GL_FRAMEBUFFER()
    {
        return 0x00008d40;
    }


    @Override
    public int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME()
    {
        return 0x00008cd1;
    }


    @Override
    public int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE()
    {
        return 0x00008cd0;
    }


    @Override
    public int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE()
    {
        return 0x00008cd3;
    }


    @Override
    public int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL()
    {
        return 0x00008cd2;
    }


    @Override
    public int GL_FRAMEBUFFER_BINDING()
    {
        return 0x00008ca6;
    }


    @Override
    public int GL_FRAMEBUFFER_COMPLETE()
    {
        return 0x00008cd5;
    }


    @Override
    public int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT()
    {
        return 0x00008cd6;
    }


    @Override
    public int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS()
    {
        return 0x00008cd9;
    }


    @Override
    public int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT()
    {
        return 0x00008cd7;
    }


    @Override
    public int GL_FRAMEBUFFER_UNSUPPORTED()
    {
        return 0x00008cdd;
    }


    @Override
    public int GL_FRONT()
    {
        return 0x00000404;
    }


    @Override
    public int GL_FRONT_AND_BACK()
    {
        return 0x00000408;
    }


    @Override
    public int GL_FRONT_FACE()
    {
        return 0x00000b46;
    }


    @Override
    public int GL_FUNC_ADD()
    {
        return 0x00008006;
    }


    @Override
    public int GL_FUNC_REVERSE_SUBTRACT()
    {
        return 0x0000800b;
    }


    @Override
    public int GL_FUNC_SUBTRACT()
    {
        return 0x0000800a;
    }


    @Override
    public int GL_GENERATE_MIPMAP()
    {
        return 0x00008191;
    }


    @Override
    public int GL_GENERATE_MIPMAP_HINT()
    {
        return 0x00008192;
    }


    @Override
    public int GL_GEQUAL()
    {
        return 0x00000206;
    }


    @Override
    public int GL_GREATER()
    {
        return 0x00000204;
    }


    @Override
    public int GL_GREEN_BITS()
    {
        return 0x00000d53;
    }


    @Override
    public int GL_HIGH_FLOAT()
    {
        return 0x00008df2;
    }


    @Override
    public int GL_HIGH_INT()
    {
        return 0x00008df5;
    }


    @Override
    public int GL_IMPLEMENTATION_COLOR_READ_FORMAT()
    {
        return 0x00008b9b;
    }


    @Override
    public int GL_IMPLEMENTATION_COLOR_READ_TYPE()
    {
        return 0x00008b9a;
    }


    @Override
    public int GL_INCR()
    {
        return 0x00001e02;
    }


    @Override
    public int GL_INCR_WRAP()
    {
        return 0x00008507;
    }


    @Override
    public int GL_INFO_LOG_LENGTH()
    {
        return 0x00008b84;
    }


    @Override
    public int GL_INT()
    {
        return 0x00001404;
    }


    @Override
    public int GL_INTERPOLATE()
    {
        return 0x00008575;
    }


    @Override
    public int GL_INT_VEC2()
    {
        return 0x00008b53;
    }


    @Override
    public int GL_INT_VEC3()
    {
        return 0x00008b54;
    }


    @Override
    public int GL_INT_VEC4()
    {
        return 0x00008b55;
    }


    @Override
    public int GL_INVALID_ENUM()
    {
        return 0x00000500;
    }


    @Override
    public int GL_INVALID_FRAMEBUFFER_OPERATION()
    {
        return 0x00000506;
    }


    @Override
    public int GL_INVALID_OPERATION()
    {
        return 0x00000502;
    }


    @Override
    public int GL_INVALID_VALUE()
    {
        return 0x00000501;
    }


    @Override
    public int GL_INVERT()
    {
        return 0x0000150a;
    }


    @Override
    public int GL_KEEP()
    {
        return 0x00001e00;
    }


    @Override
    public int GL_LEQUAL()
    {
        return 0x00000203;
    }


    @Override
    public int GL_LESS()
    {
        return 0x00000201;
    }


    @Override
    public int GL_LINEAR()
    {
        return 0x00002601;
    }


    @Override
    public int GL_LINEAR_MIPMAP_LINEAR()
    {
        return 0x00002703;
    }


    @Override
    public int GL_LINEAR_MIPMAP_NEAREST()
    {
        return 0x00002701;
    }


    @Override
    public int GL_LINES()
    {
        return 0x00000001;
    }


    @Override
    public int GL_LINE_LOOP()
    {
        return 0x00000002;
    }


    @Override
    public int GL_LINE_STRIP()
    {
        return 0x00000003;
    }


    @Override
    public int GL_LINE_WIDTH()
    {
        return 0x00000b21;
    }


    @Override
    public int GL_LINK_STATUS()
    {
        return 0x00008b82;
    }


    @Override
    public int GL_LOGIC_OP_MODE()
    {
        return 0x00000bf0;
    }


    @Override
    public int GL_LOW_FLOAT()
    {
        return 0x00008df0;
    }


    @Override
    public int GL_LOW_INT()
    {
        return 0x00008df3;
    }


    @Override
    public int GL_LUMINANCE()
    {
        return 0x00001909;
    }


    @Override
    public int GL_LUMINANCE_ALPHA()
    {
        return 0x0000190a;
    }


    @Override
    public int GL_MATRIX_MODE()
    {
        return 0x00000ba0;
    }


    @Override
    public int GL_MAX_CLIP_PLANES()
    {
        return 0x00000d32;
    }


    @Override
    public int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS()
    {
        return 0x00008b4d;
    }


    @Override
    public int GL_MAX_CUBE_MAP_TEXTURE_SIZE()
    {
        return 0x0000851c;
    }


    @Override
    public int GL_MAX_FRAGMENT_UNIFORM_VECTORS()
    {
        return 0x00008dfd;
    }


    @Override
    public int GL_MAX_RENDERBUFFER_SIZE()
    {
        return 0x000084e8;
    }


    @Override
    public int GL_MAX_TEXTURE_IMAGE_UNITS()
    {
        return 0x00008872;
    }


    @Override
    public int GL_MAX_TEXTURE_SIZE()
    {
        return 0x00000d33;
    }


    @Override
    public int GL_MAX_VARYING_VECTORS()
    {
        return 0x00008dfc;
    }


    @Override
    public int GL_MAX_VERTEX_ATTRIBS()
    {
        return 0x00008869;
    }


    @Override
    public int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS()
    {
        return 0x00008b4c;
    }


    @Override
    public int GL_MAX_VERTEX_UNIFORM_VECTORS()
    {
        return 0x00008dfb;
    }


    @Override
    public int GL_MAX_VIEWPORT_DIMS()
    {
        return 0x00000d3a;
    }


    @Override
    public int GL_MEDIUM_FLOAT()
    {
        return 0x00008df1;
    }


    @Override
    public int GL_MEDIUM_INT()
    {
        return 0x00008df4;
    }


    @Override
    public int GL_MIRRORED_REPEAT()
    {
        return 0x00008370;
    }


    @Override
    public int GL_MODELVIEW_MATRIX()
    {
        return 0x00000ba6;
    }


    @Override
    public int GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES()
    {
        return 0x0000898d;
    }


    @Override
    public int GL_MODELVIEW_STACK_DEPTH()
    {
        return 0x00000ba3;
    }


    @Override
    public int GL_NEAREST()
    {
        return 0x00002600;
    }


    @Override
    public int GL_NEAREST_MIPMAP_LINEAR()
    {
        return 0x00002702;
    }


    @Override
    public int GL_NEAREST_MIPMAP_NEAREST()
    {
        return 0x00002700;
    }


    @Override
    public int GL_NEVER()
    {
        return 0x00000200;
    }


    @Override
    public int GL_NICEST()
    {
        return 0x00001102;
    }


    @Override
    public int GL_NONE()
    {
        return 0x00000000;
    }


    @Override
    public int GL_NORMAL_ARRAY_POINTER()
    {
        return 0x0000808f;
    }


    @Override
    public int GL_NORMAL_ARRAY_STRIDE()
    {
        return 0x0000807f;
    }


    @Override
    public int GL_NORMAL_ARRAY_TYPE()
    {
        return 0x0000807e;
    }


    @Override
    public int GL_NOTEQUAL()
    {
        return 0x00000205;
    }


    @Override
    public int GL_NO_ERROR()
    {
        return 0x00000000;
    }


    @Override
    public int GL_NUM_COMPRESSED_TEXTURE_FORMATS()
    {
        return 0x000086a2;
    }


    @Override
    public int GL_NUM_SHADER_BINARY_FORMATS()
    {
        return 0x00008df9;
    }


    @Override
    public int GL_ONE()
    {
        return 0x00000001;
    }


    @Override
    public int GL_ONE_MINUS_CONSTANT_ALPHA()
    {
        return 0x00008004;
    }


    @Override
    public int GL_ONE_MINUS_CONSTANT_COLOR()
    {
        return 0x00008002;
    }


    @Override
    public int GL_ONE_MINUS_DST_ALPHA()
    {
        return 0x00000305;
    }


    @Override
    public int GL_ONE_MINUS_DST_COLOR()
    {
        return 0x00000307;
    }


    @Override
    public int GL_ONE_MINUS_SRC_ALPHA()
    {
        return 0x00000303;
    }


    @Override
    public int GL_ONE_MINUS_SRC_COLOR()
    {
        return 0x00000301;
    }


    @Override
    public int GL_OPERAND0_ALPHA()
    {
        return 0x00008598;
    }


    @Override
    public int GL_OPERAND0_RGB()
    {
        return 0x00008590;
    }


    @Override
    public int GL_OPERAND1_ALPHA()
    {
        return 0x00008599;
    }


    @Override
    public int GL_OPERAND1_RGB()
    {
        return 0x00008591;
    }


    @Override
    public int GL_OPERAND2_ALPHA()
    {
        return 0x0000859a;
    }


    @Override
    public int GL_OPERAND2_RGB()
    {
        return 0x00008592;
    }


    @Override
    public int GL_OUT_OF_MEMORY()
    {
        return 0x00000505;
    }


    @Override
    public int GL_PACK_ALIGNMENT()
    {
        return 0x00000d05;
    }


    @Override
    public int GL_POINTS()
    {
        return 0x00000000;
    }


    @Override
    public int GL_POINT_DISTANCE_ATTENUATION()
    {
        return 0x00008129;
    }


    @Override
    public int GL_POINT_FADE_THRESHOLD_SIZE()
    {
        return 0x00008128;
    }


    @Override
    public int GL_POINT_SIZE()
    {
        return 0x00000b11;
    }


    @Override
    public int GL_POINT_SIZE_ARRAY_BUFFER_BINDING_OES()
    {
        return 0x00008b9f;
    }


    @Override
    public int GL_POINT_SIZE_ARRAY_OES()
    {
        return 0x00008b9c;
    }


    @Override
    public int GL_POINT_SIZE_ARRAY_POINTER_OES()
    {
        return 0x0000898c;
    }


    @Override
    public int GL_POINT_SIZE_ARRAY_STRIDE_OES()
    {
        return 0x0000898b;
    }


    @Override
    public int GL_POINT_SIZE_ARRAY_TYPE_OES()
    {
        return 0x0000898a;
    }


    @Override
    public int GL_POINT_SIZE_MAX()
    {
        return 0x00008127;
    }


    @Override
    public int GL_POINT_SIZE_MIN()
    {
        return 0x00008126;
    }


    @Override
    public int GL_POINT_SPRITE_OES()
    {
        return 0x00008861;
    }


    @Override
    public int GL_POLYGON_OFFSET_FACTOR()
    {
        return 0x00008038;
    }


    @Override
    public int GL_POLYGON_OFFSET_FILL()
    {
        return 0x00008037;
    }


    @Override
    public int GL_POLYGON_OFFSET_UNITS()
    {
        return 0x00002a00;
    }


    @Override
    public int GL_PREVIOUS()
    {
        return 0x00008578;
    }


    @Override
    public int GL_PRIMARY_COLOR()
    {
        return 0x00008577;
    }


    @Override
    public int GL_PROJECTION_MATRIX()
    {
        return 0x00000ba7;
    }


    @Override
    public int GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES()
    {
        return 0x0000898e;
    }


    @Override
    public int GL_PROJECTION_STACK_DEPTH()
    {
        return 0x00000ba4;
    }


    @Override
    public int GL_RED_BITS()
    {
        return 0x00000d52;
    }


    @Override
    public int GL_RENDERBUFFER()
    {
        return 0x00008d41;
    }


    @Override
    public int GL_RENDERBUFFER_ALPHA_SIZE()
    {
        return 0x00008d53;
    }


    @Override
    public int GL_RENDERBUFFER_BINDING()
    {
        return 0x00008ca7;
    }


    @Override
    public int GL_RENDERBUFFER_BLUE_SIZE()
    {
        return 0x00008d52;
    }


    @Override
    public int GL_RENDERBUFFER_DEPTH_SIZE()
    {
        return 0x00008d54;
    }


    @Override
    public int GL_RENDERBUFFER_GREEN_SIZE()
    {
        return 0x00008d51;
    }


    @Override
    public int GL_RENDERBUFFER_HEIGHT()
    {
        return 0x00008d43;
    }


    @Override
    public int GL_RENDERBUFFER_INTERNAL_FORMAT()
    {
        return 0x00008d44;
    }


    @Override
    public int GL_RENDERBUFFER_RED_SIZE()
    {
        return 0x00008d50;
    }


    @Override
    public int GL_RENDERBUFFER_STENCIL_SIZE()
    {
        return 0x00008d55;
    }


    @Override
    public int GL_RENDERBUFFER_WIDTH()
    {
        return 0x00008d42;
    }


    @Override
    public int GL_RENDERER()
    {
        return 0x00001f01;
    }


    @Override
    public int GL_REPEAT()
    {
        return 0x00002901;
    }


    @Override
    public int GL_REPLACE()
    {
        return 0x00001e01;
    }


    @Override
    public int GL_RGB()
    {
        return 0x00001907;
    }


    @Override
    public int GL_RGB565()
    {
        return 0x00008d62;
    }


    @Override
    public int GL_RGB5_A1()
    {
        return 0x00008057;
    }


    @Override
    public int GL_RGBA()
    {
        return 0x00001908;
    }


    @Override
    public int GL_RGBA4()
    {
        return 0x00008056;
    }


    @Override
    public int GL_RGB_SCALE()
    {
        return 0x00008573;
    }


    @Override
    public int GL_SAMPLER_2D()
    {
        return 0x00008b5e;
    }


    @Override
    public int GL_SAMPLER_CUBE()
    {
        return 0x00008b60;
    }


    @Override
    public int GL_SAMPLES()
    {
        return 0x000080a9;
    }


    @Override
    public int GL_SAMPLE_ALPHA_TO_COVERAGE()
    {
        return 0x0000809e;
    }


    @Override
    public int GL_SAMPLE_BUFFERS()
    {
        return 0x000080a8;
    }


    @Override
    public int GL_SAMPLE_COVERAGE()
    {
        return 0x000080a0;
    }


    @Override
    public int GL_SAMPLE_COVERAGE_INVERT()
    {
        return 0x000080ab;
    }


    @Override
    public int GL_SAMPLE_COVERAGE_VALUE()
    {
        return 0x000080aa;
    }


    @Override
    public int GL_SCISSOR_BOX()
    {
        return 0x00000c10;
    }


    @Override
    public int GL_SCISSOR_TEST()
    {
        return 0x00000c11;
    }


    @Override
    public int GL_SHADER_BINARY_FORMATS()
    {
        return 0x00008df8;
    }


    @Override
    public int GL_SHADER_COMPILER()
    {
        return 0x00008dfa;
    }


    @Override
    public int GL_SHADER_SOURCE_LENGTH()
    {
        return 0x00008b88;
    }


    @Override
    public int GL_SHADER_TYPE()
    {
        return 0x00008b4f;
    }


    @Override
    public int GL_SHADE_MODEL()
    {
        return 0x00000b54;
    }


    @Override
    public int GL_SHADING_LANGUAGE_VERSION()
    {
        return 0x00008b8c;
    }


    @Override
    public int GL_SHORT()
    {
        return 0x00001402;
    }


    @Override
    public int GL_SRC0_ALPHA()
    {
        return 0x00008588;
    }


    @Override
    public int GL_SRC0_RGB()
    {
        return 0x00008580;
    }


    @Override
    public int GL_SRC1_ALPHA()
    {
        return 0x00008589;
    }


    @Override
    public int GL_SRC1_RGB()
    {
        return 0x00008581;
    }


    @Override
    public int GL_SRC2_ALPHA()
    {
        return 0x0000858a;
    }


    @Override
    public int GL_SRC2_RGB()
    {
        return 0x00008582;
    }


    @Override
    public int GL_SRC_ALPHA()
    {
        return 0x00000302;
    }


    @Override
    public int GL_SRC_ALPHA_SATURATE()
    {
        return 0x00000308;
    }


    @Override
    public int GL_SRC_COLOR()
    {
        return 0x00000300;
    }


    @Override
    public int GL_STATIC_DRAW()
    {
        return 0x000088e4;
    }


    @Override
    public int GL_STENCIL_ATTACHMENT()
    {
        return 0x00008d20;
    }


    @Override
    public int GL_STENCIL_BACK_FAIL()
    {
        return 0x00008801;
    }


    @Override
    public int GL_STENCIL_BACK_FUNC()
    {
        return 0x00008800;
    }


    @Override
    public int GL_STENCIL_BACK_PASS_DEPTH_FAIL()
    {
        return 0x00008802;
    }


    @Override
    public int GL_STENCIL_BACK_PASS_DEPTH_PASS()
    {
        return 0x00008803;
    }


    @Override
    public int GL_STENCIL_BACK_REF()
    {
        return 0x00008ca3;
    }


    @Override
    public int GL_STENCIL_BACK_VALUE_MASK()
    {
        return 0x00008ca4;
    }


    @Override
    public int GL_STENCIL_BACK_WRITEMASK()
    {
        return 0x00008ca5;
    }


    @Override
    public int GL_STENCIL_BITS()
    {
        return 0x00000d57;
    }


    @Override
    public int GL_STENCIL_BUFFER_BIT()
    {
        return 0x00000400;
    }


    @Override
    public int GL_STENCIL_CLEAR_VALUE()
    {
        return 0x00000b91;
    }


    @Override
    public int GL_STENCIL_FAIL()
    {
        return 0x00000b94;
    }


    @Override
    public int GL_STENCIL_FUNC()
    {
        return 0x00000b92;
    }


    @Override
    public int GL_STENCIL_INDEX()
    {
        return 0x00001901;
    }


    @Override
    public int GL_STENCIL_INDEX8()
    {
        return 0x00008d48;
    }


    @Override
    public int GL_STENCIL_PASS_DEPTH_FAIL()
    {
        return 0x00000b95;
    }


    @Override
    public int GL_STENCIL_PASS_DEPTH_PASS()
    {
        return 0x00000b96;
    }


    @Override
    public int GL_STENCIL_REF()
    {
        return 0x00000b97;
    }


    @Override
    public int GL_STENCIL_TEST()
    {
        return 0x00000b90;
    }


    @Override
    public int GL_STENCIL_VALUE_MASK()
    {
        return 0x00000b93;
    }


    @Override
    public int GL_STENCIL_WRITEMASK()
    {
        return 0x00000b98;
    }


    @Override
    public int GL_STREAM_DRAW()
    {
        return 0x000088e0;
    }


    @Override
    public int GL_SUBPIXEL_BITS()
    {
        return 0x00000d50;
    }


    @Override
    public int GL_SUBTRACT()
    {
        return 0x000084e7;
    }


    @Override
    public int GL_TEXTURE()
    {
        return 0x00001702;
    }


    @Override
    public int GL_TEXTURE0()
    {
        return 0x000084c0;
    }


    @Override
    public int GL_TEXTURE1()
    {
        return 0x000084c1;
    }


    @Override
    public int GL_TEXTURE2()
    {
        return 0x000084c2;
    }


    @Override
    public int GL_TEXTURE3()
    {
        return 0x000084c3;
    }


    @Override
    public int GL_TEXTURE4()
    {
        return 0x000084c4;
    }


    @Override
    public int GL_TEXTURE5()
    {
        return 0x000084c5;
    }


    @Override
    public int GL_TEXTURE6()
    {
        return 0x000084c6;
    }


    @Override
    public int GL_TEXTURE7()
    {
        return 0x000084c7;
    }


    @Override
    public int GL_TEXTURE8()
    {
        return 0x000084c8;
    }


    @Override
    public int GL_TEXTURE9()
    {
        return 0x000084c9;
    }


    @Override
    public int GL_TEXTURE10()
    {
        return 0x000084ca;
    }


    @Override
    public int GL_TEXTURE11()
    {
        return 0x000084cb;
    }


    @Override
    public int GL_TEXTURE12()
    {
        return 0x000084cc;
    }


    @Override
    public int GL_TEXTURE13()
    {
        return 0x000084cd;
    }


    @Override
    public int GL_TEXTURE14()
    {
        return 0x000084ce;
    }


    @Override
    public int GL_TEXTURE15()
    {
        return 0x000084cf;
    }


    @Override
    public int GL_TEXTURE16()
    {
        return 0x000084d0;
    }


    @Override
    public int GL_TEXTURE17()
    {
        return 0x000084d1;
    }


    @Override
    public int GL_TEXTURE18()
    {
        return 0x000084d2;
    }


    @Override
    public int GL_TEXTURE19()
    {
        return 0x000084d3;
    }


    @Override
    public int GL_TEXTURE20()
    {
        return 0x000084d4;
    }


    @Override
    public int GL_TEXTURE21()
    {
        return 0x000084d5;
    }


    @Override
    public int GL_TEXTURE22()
    {
        return 0x000084d6;
    }


    @Override
    public int GL_TEXTURE23()
    {
        return 0x000084d7;
    }


    @Override
    public int GL_TEXTURE24()
    {
        return 0x000084d8;
    }


    @Override
    public int GL_TEXTURE25()
    {
        return 0x000084d9;
    }


    @Override
    public int GL_TEXTURE26()
    {
        return 0x000084da;
    }


    @Override
    public int GL_TEXTURE27()
    {
        return 0x000084db;
    }


    @Override
    public int GL_TEXTURE28()
    {
        return 0x000084dc;
    }


    @Override
    public int GL_TEXTURE29()
    {
        return 0x000084dd;
    }


    @Override
    public int GL_TEXTURE30()
    {
        return 0x000084de;
    }


    @Override
    public int GL_TEXTURE31()
    {
        return 0x000084df;
    }


    @Override
    public int GL_TEXTURE_2D()
    {
        return 0x00000de1;
    }


    @Override
    public int GL_TEXTURE_BINDING_2D()
    {
        return 0x00008069;
    }


    @Override
    public int GL_TEXTURE_BINDING_CUBE_MAP()
    {
        return 0x00008514;
    }


    @Override
    public int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING()
    {
        return 0x0000889a;
    }


    @Override
    public int GL_TEXTURE_COORD_ARRAY_POINTER()
    {
        return 0x00008092;
    }


    @Override
    public int GL_TEXTURE_COORD_ARRAY_SIZE()
    {
        return 0x00008088;
    }


    @Override
    public int GL_TEXTURE_COORD_ARRAY_STRIDE()
    {
        return 0x0000808a;
    }


    @Override
    public int GL_TEXTURE_COORD_ARRAY_TYPE()
    {
        return 0x00008089;
    }


    @Override
    public int GL_TEXTURE_CUBE_MAP()
    {
        return 0x00008513;
    }


    @Override
    public int GL_TEXTURE_CUBE_MAP_NEGATIVE_X()
    {
        return 0x00008516;
    }


    @Override
    public int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y()
    {
        return 0x00008518;
    }


    @Override
    public int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z()
    {
        return 0x0000851a;
    }


    @Override
    public int GL_TEXTURE_CUBE_MAP_POSITIVE_X()
    {
        return 0x00008515;
    }


    @Override
    public int GL_TEXTURE_CUBE_MAP_POSITIVE_Y()
    {
        return 0x00008517;
    }


    @Override
    public int GL_TEXTURE_CUBE_MAP_POSITIVE_Z()
    {
        return 0x00008519;
    }


    @Override
    public int GL_TEXTURE_MAG_FILTER()
    {
        return 0x00002800;
    }


    @Override
    public int GL_TEXTURE_MATRIX()
    {
        return 0x00000ba8;
    }


    @Override
    public int GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES()
    {
        return 0x0000898f;
    }


    @Override
    public int GL_TEXTURE_MIN_FILTER()
    {
        return 0x00002801;
    }


    @Override
    public int GL_TEXTURE_STACK_DEPTH()
    {
        return 0x00000ba5;
    }


    @Override
    public int GL_TEXTURE_WRAP_S()
    {
        return 0x00002802;
    }


    @Override
    public int GL_TEXTURE_WRAP_T()
    {
        return 0x00002803;
    }


    @Override
    public int GL_TRIANGLES()
    {
        return 0x00000004;
    }


    @Override
    public int GL_TRIANGLE_FAN()
    {
        return 0x00000006;
    }


    @Override
    public int GL_TRIANGLE_STRIP()
    {
        return 0x00000005;
    }


    @Override
    public int GL_TRUE()
    {
        return 1;
    }


    @Override
    public int GL_UNPACK_ALIGNMENT()
    {
        return 0x00000cf5;
    }


    @Override
    public int GL_UNSIGNED_BYTE()
    {
        return 0x00001401;
    }


    @Override
    public int GL_UNSIGNED_INT()
    {
        return 0x00001405;
    }


    @Override
    public int GL_UNSIGNED_SHORT()
    {
        return 0x00001403;
    }


    @Override
    public int GL_UNSIGNED_SHORT_4_4_4_4()
    {
        return 0x00008033;
    }


    @Override
    public int GL_UNSIGNED_SHORT_5_5_5_1()
    {
        return 0x00008034;
    }


    @Override
    public int GL_UNSIGNED_SHORT_5_6_5()
    {
        return 0x00008363;
    }


    @Override
    public int GL_VALIDATE_STATUS()
    {
        return 0x00008b83;
    }


    @Override
    public int GL_VENDOR()
    {
        return 0x00001f00;
    }


    @Override
    public int GL_VERSION()
    {
        return 0x00001f02;
    }


    @Override
    public int GL_VERTEX_ARRAY_BUFFER_BINDING()
    {
        return 0x00008896;
    }


    @Override
    public int GL_VERTEX_ARRAY_POINTER()
    {
        return 0x0000808e;
    }


    @Override
    public int GL_VERTEX_ARRAY_SIZE()
    {
        return 0x0000807a;
    }


    @Override
    public int GL_VERTEX_ARRAY_STRIDE()
    {
        return 0x0000807c;
    }


    @Override
    public int GL_VERTEX_ARRAY_TYPE()
    {
        return 0x0000807b;
    }


    @Override
    public int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING()
    {
        return 0x0000889f;
    }


    @Override
    public int GL_VERTEX_ATTRIB_ARRAY_ENABLED()
    {
        return 0x00008622;
    }


    @Override
    public int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED()
    {
        return 0x0000886a;
    }


    @Override
    public int GL_VERTEX_ATTRIB_ARRAY_POINTER()
    {
        return 0x00008645;
    }


    @Override
    public int GL_VERTEX_ATTRIB_ARRAY_SIZE()
    {
        return 0x00008623;
    }


    @Override
    public int GL_VERTEX_ATTRIB_ARRAY_STRIDE()
    {
        return 0x00008624;
    }


    @Override
    public int GL_VERTEX_ATTRIB_ARRAY_TYPE()
    {
        return 0x00008625;
    }


    @Override
    public int GL_VERTEX_SHADER()
    {
        return 0x00008b31;
    }


    @Override
    public int GL_VIEWPORT()
    {
        return 0x00000ba2;
    }


    @Override
    public int GL_WRITE_ONLY()
    {
        return 0x000088b9;
    }


    @Override
    public int GL_ZERO()
    {
        return 0x00000000;
    }


    @Override
    public void glActiveTexture(int textureUnit)
    {
        unsupported("glActiveTexture");
    }


    @Override
    public void glAttachShader(int programId, int shaderId)
    {
        unsupported("glAttachShader");
    }


    @Override
    public void glBindAttribLocation(int programId, int attributeIndex, String attributeName)
    {
        unsupported("glBindAttribLocation");
    }


    @Override
    public void glBindBuffer(int vertexBufferType, int vertexBufferId)
    {
        unsupported("glBindBuffer");
    }


    @Override
    public void glBindTexture(int textureType, int textureId)
    {
        unsupported("glBindTexture");
    }


    @Override
    public void glBlendColor(float red, float green, float blue, float alpha)
    {
        unsupported("glBlendColor");
    }


    @Override
    public void glBlendEquation(int operator)
    {
        unsupported("glBlendEquation");
    }


    @Override
    public void glBlendEquationSeparate(int rgbOperator, int alphaOperator)
    {
        unsupported("glBlendEquationSeparate");
    }


    @Override
    public void glBlendFunc(int sourceFactor, int destinationFactor)
    {
        unsupported("glBlendFunc");
    }


    @Override
    public void glBlendFuncSeparate(int sourceRGBFactor, int destinationRGBFactor, int sourceAlphaFactor, int destinationAlphaFactor)
    {
        unsupported("glBlendFuncSeparator");
    }


    @Override
    public void glBufferData(int vertexBufferType, int size, Buffer data, int vertexBufferUsage)
    {
        unsupported("glBufferData");
    }


    @Override
    public void glBufferSubData(int vertexBufferType, int offset, int size, Buffer data)
    {
        unsupported("glBufferSubData");
    }


    @Override
    public void glClear(int mask)
    {
        unsupported("glClear");
    }


    @Override
    public void glClearColor(float red, float green, float blue, float alpha)
    {
        unsupported("glClearColor");
    }


    @Override
    public void glClearDepthf(float depth)
    {
        unsupported("glClearDepthf");
    }


    @Override
    public void glClearStencil(int stencil)
    {
        unsupported("glClearStencil");
    }


    @Override
    public void glColorMask(boolean red, boolean green, boolean blue, boolean alpha)
    {
        unsupported("glColorMask");
    }


    @Override
    public void glCompileShader(int shaderId)
    {
        unsupported("glCompileShader");
    }


    @Override
    public int glCreateProgram()
    {
        unsupported("glCreateProgram");

        return 0;
    }


    @Override
    public int glCreateShader(int shaderType)
    {
        unsupported("glCreateShader");

        return 0;
    }


    @Override
    public void glDeleteBuffers(int vertexBufferType, int[] vertexBufferIds, int offset)
    {
        unsupported("glDeleteBuffers");
    }


    @Override
    public void glDeleteProgram(int programId)
    {
        unsupported("glDeleteProgram");
    }


    @Override
    public void glDeleteShader(int shaderId)
    {
        unsupported("glDeleteShader");
    }


    @Override
    public void glDeleteTextures(int count, int[] textureIds, int offset)
    {
        unsupported("glDeleteTextures");
    }


    @Override
    public void glDepthMask(boolean writable)
    {
        unsupported("glDepthMask");
    }


    @Override
    public void glDetachShader(int programId, int shaderId)
    {
        unsupported("glDetachShader");
    }


    @Override
    public void glDisable(int capability)
    {
        unsupported("glDisable");
    }


    @Override
    public void glDisableVertexAttribArray(int index)
    {
        unsupported("glDisableVertexAttribArray");
    }


    @Override
    public void glDrawArrays(int mode, int first, int count)
    {
        unsupported("glDrawArrays");
    }


    @Override
    public void glDrawElements(int mode, int count, int type, Buffer indices)
    {
        unsupported("glDrawElements");
    }


    @Override
    public void glDrawElements(int mode, int count, int type, int offset)
    {
        unsupported("glDrawElements");
    }


    @Override
    public void glEnable(int capability)
    {
        unsupported("glEnable");
    }


    @Override
    public void glEnableVertexAttribArray(int index)
    {
        unsupported("glEnableVertexAttribArray");
    }


    @Override
    public void glFinish()
    {
        unsupported("glFinish");
    }


    @Override
    public void glFlush()
    {
        unsupported("glFlush");
    }


    @Override
    public void glGenBuffers(int vertexBufferType, int[] vertexBufferIds, int offset)
    {
        unsupported("glGenBuffers");
    }


    @Override
    public void glGenerateMipmap(int textureType)
    {
        unsupported("glGenerateMipmap");
    }


    @Override
    public void glGenTextures(int textureType, int[] textureIds, int offset)
    {
        unsupported("glGenTextures");
    }


    @Override
    public int glGetAttribLocation(int programId, String attributeName)
    {
        unsupported("glGetAttribLocation");

        return 0;
    }


    @Override
    public void glGetBooleanv(int parameterId, boolean[] params, int offset)
    {
        unsupported("glGetBooleanv");
    }


    @Override
    public void glGetBooleanv(int parameterId, IntBuffer params)
    {
        unsupported("glGetBooleanv");
    }


    @Override
    public int glGetError()
    {
        unsupported("glGetError");

        return 0;
    }


    @Override
    public void glGetFloatv(int parameterId, FloatBuffer params)
    {
        unsupported("glGetFloatv");
    }


    @Override
    public void glGetFloatv(int parameterId, float[] params, int offset)
    {
        unsupported("glGetFloatv");
    }


    @Override
    public void glGetIntegerv(int parameterId, IntBuffer params)
    {
        unsupported("glGetIntegerv");
    }


    @Override
    public void glGetIntegerv(int parameterId, int[] params, int offset)
    {
        unsupported("glGetIntegerv");
    }


    @Override
    public String glGetProgramInfoLog(int programId)
    {
        unsupported("glGetProgramInfoLog");

        return null;
    }


    @Override
    public void glGetProgramiv(int programId, int parameterId, int[] params, int offset)
    {
        unsupported("glGetProgramiv");
    }


    @Override
    public String glGetShaderInfoLog(int shaderId)
    {
        unsupported("glGetShaderInfoLog");

        return null;
    }


    @Override
    public void glGetShaderiv(int shaderId, int parameterId, int[] params, int offset)
    {
        unsupported("glGetShaderiv");
    }


    @Override
    public String glGetString(int parameterId)
    {
        unsupported("glGetString");

        return null;
    }


    @Override
    public void glGetUniformfv(int programId, int uniformLocation, FloatBuffer params)
    {
        unsupported("glGetUniformfv");
    }


    @Override
    public void glGetUniformfv(int programId, int uniformLocation, float[] params, int offset)
    {
        unsupported("glGetUniformfv");
    }


    @Override
    public void glGetUniformiv(int programId, int uniformLocation, IntBuffer params)
    {
        unsupported("glGetUniformiv");
    }


    @Override
    public void glGetUniformiv(int programId, int uniformLocation, int[] params, int offset)
    {
        unsupported("glGetUniformiv");
    }


    @Override
    public int glGetUniformLocation(int programId, String variableName)
    {
        unsupported("glGetUniformLocation");

        return 0;
    }


    @Override
    public boolean glIsEnabled(int capability)
    {
        unsupported("glDisable");

        return false;
    }


    @Override
    public void glLinkProgram(int programId)
    {
        unsupported("glLinkProgram");
    }


    @Override
    public void glReleaseShaderCompiler()
    {
        unsupported("glReleaseShaderCompiler");
    }


    @Override
    public void glShaderSource(int shaderId, String shaderSourceCode)
    {
        unsupported("glShaderSource");
    }


    @Override
    public void glStencilFunc(int comparisonOperator, int referenceValue, int mask)
    {
        unsupported("glStencilFunc");
    }


    @Override
    public void glStencilFuncSeparate(int face, int comparisonOperator, int referenceValue, int mask)
    {
        unsupported("glStencilFuncSeparate");
    }


    @Override
    public void glStencilOp(int stencilFail, int depthFail, int pass)
    {
        unsupported("glStencilOp");
    }


    @Override
    public void glStencilOpSeparate(int face, int stencilFail, int depthFail, int pass)
    {
        unsupported("glStencilOpSeparate");
    }


    @Override
    public void glTexParameteri(int textureType, int parameterId, int parameterValue)
    {
        unsupported("glTexParameteri");
    }


    @Override
    public void glUniform1f(int uniformLocation, float x)
    {
        unsupported("glUniform1f");
    }


    @Override
    public void glUniform1fv(int uniformLocation, int count, FloatBuffer values)
    {
        unsupported("glUniform1fv");
    }


    @Override
    public void glUniform1fv(int uniformLocation, int count, float[] values, int offset)
    {
        unsupported("glUniform1fv");
    }


    @Override
    public void glUniform1i(int uniformLocation, int x)
    {
        unsupported("glUniform1i");
    }


    @Override
    public void glUniform1iv(int uniformLocation, int count, IntBuffer values)
    {
        unsupported("glUniform1iv");
    }


    @Override
    public void glUniform1iv(int uniformLocation, int count, int[] values, int offset)
    {
        unsupported("glUniform1iv");
    }


    @Override
    public void glUniform2f(int uniformLocation, float x, float y)
    {
        unsupported("glUniform2f");
    }


    @Override
    public void glUniform2fv(int uniformLocation, int count, FloatBuffer values)
    {
        unsupported("glUniform2fv");
    }


    @Override
    public void glUniform2fv(int uniformLocation, int count, float[] values, int offset)
    {
        unsupported("glUniform2fv");
    }


    @Override
    public void glUniform2i(int uniformLocation, int x, int y)
    {
        unsupported("glUniform2i");
    }


    @Override
    public void glUniform2iv(int uniformLocation, int count, IntBuffer values)
    {
        unsupported("glUniform2iv");
    }


    @Override
    public void glUniform2iv(int uniformLocation, int count, int[] values, int offset)
    {
        unsupported("glUniform2iv");
    }


    @Override
    public void glUniform3f(int uniformLocation, float x, float y, float z)
    {
        unsupported("glUniform3f");
    }


    @Override
    public void glUniform3fv(int uniformLocation, int count, FloatBuffer values)
    {
        unsupported("glUniform3fv");
    }


    @Override
    public void glUniform3fv(int uniformLocation, int count, float[] values, int offset)
    {
        unsupported("glUniform3fv");
    }


    @Override
    public void glUniform3i(int uniformLocation, int x, int y, int z)
    {
        unsupported("glUniform3i");
    }


    @Override
    public void glUniform3iv(int uniformLocation, int count, IntBuffer values)
    {
        unsupported("glUniform3iv");
    }


    @Override
    public void glUniform3iv(int uniformLocation, int count, int[] values, int offset)
    {
        unsupported("glUniform3iv");
    }


    @Override
    public void glUniform4f(int uniformLocation, float x, float y, float z, float w)
    {
        unsupported("glUniform4f");
    }


    @Override
    public void glUniform4fv(int uniformLocation, int count, FloatBuffer values)
    {
        unsupported("glUniform4fv");
    }


    @Override
    public void glUniform4fv(int uniformLocation, int count, float[] values, int offset)
    {
        unsupported("glUniform4fv");
    }


    @Override
    public void glUniform4i(int uniformLocation, int x, int y, int z, int w)
    {
        unsupported("glUniform4i");
    }


    @Override
    public void glUniform4iv(int uniformLocation, int count, IntBuffer values)
    {
        unsupported("glUniform4iv");
    }


    @Override
    public void glUniform4iv(int uniformLocation, int count, int[] values, int offset)
    {
        unsupported("glUniform4iv");
    }


    @Override
    public void glUniformMatrix2fv(int uniformLocation, int count, boolean transpose, FloatBuffer values)
    {
        unsupported("glUniformMatrix2fv");
    }


    @Override
    public void glUniformMatrix2fv(int uniformLocation, int count, boolean transpose, float[] values, int offset)
    {
        unsupported("glUniformMatrix2fv");
    }


    @Override
    public void glUniformMatrix3fv(int uniformLocation, int count, boolean transpose, FloatBuffer values)
    {
        unsupported("glUniformMatrix3fv");
    }


    @Override
    public void glUniformMatrix3fv(int uniformLocation, int count, boolean transpose, float[] values, int offset)
    {
        unsupported("glUniformMatrix3fv");
    }


    @Override
    public void glUniformMatrix4fv(int uniformLocation, int count, boolean transpose, FloatBuffer values)
    {
        unsupported("glUniformMatrix4fv");
    }


    @Override
    public void glUniformMatrix4fv(int uniformLocation, int count, boolean transpose, float[] values, int offset)
    {
        unsupported("glUniformMatrix4fv");
    }


    @Override
    public void glUseProgram(int programId)
    {
        unsupported("glUseProgram");
    }


    @Override
    public void glVertexAttrib1f(int vertexAttributeIndex, float x)
    {
        unsupported("glVertexAttrib1f");
    }


    @Override
    public void glVertexAttrib1fv(int vertexAttributeIndex, FloatBuffer values)
    {
        unsupported("glVertexAttrib1fv");
    }


    @Override
    public void glVertexAttrib1fv(int vertexAttributeIndex, float[] values, int offset)
    {
        unsupported("glVertexAttrib1fv");
    }


    @Override
    public void glVertexAttrib2f(int vertexAttributeIndex, float x, float y)
    {
        unsupported("glVertexAttrib2f");
    }


    @Override
    public void glVertexAttrib2fv(int vertexAttributeIndex, FloatBuffer values)
    {
        unsupported("glVertexAttrib2fv");
    }


    @Override
    public void glVertexAttrib2fv(int vertexAttributeIndex, float[] values, int offset)
    {
        unsupported("glVertexAttrib2fv");
    }


    @Override
    public void glVertexAttrib3f(int vertexAttributeIndex, float x, float y, float z)
    {
        unsupported("glVertexAttrib3f");
    }


    @Override
    public void glVertexAttrib3fv(int vertexAttributeIndex, FloatBuffer values)
    {
        unsupported("glVertexAttrib3fv");
    }


    @Override
    public void glVertexAttrib3fv(int vertexAttributeIndex, float[] values, int offset)
    {
        unsupported("glVertexAttrib3fv");
    }


    @Override
    public void glVertexAttrib4f(int vertexAttributeIndex, float x, float y, float z, float w)
    {
        unsupported("glVertexAttrib4f");
    }


    @Override
    public void glVertexAttrib4fv(int vertexAttributeIndex, FloatBuffer values)
    {
        unsupported("glVertexAttrib4fv");
    }


    @Override
    public void glVertexAttrib4fv(int vertexAttributeIndex, float[] values, int offset)
    {
        unsupported("glVertexAttrib4fv");
    }


    @Override
    public void glVertexAttribPointer(int vertexAttributeIndex, int size, int type, boolean normalized, int stride, Buffer ptr)
    {
        unsupported("glVertexAttribPointer");
    }


    @Override
    public void glVertexAttribPointer(int vertexAttributeIndex, int size, int type, boolean normalized, int stride, int offset)
    {
        unsupported("glVertexAttribPointer");
    }


    @Override
    public void glViewport(int x, int y, int width, int height)
    {
        unsupported("glViewport");
    }


    private void unsupported(String name)
    {
        String message = String.format("%s does not support '%s'", this.getClass().getName(), name);

        throw new UnsupportedOperationException(message);
    }
}
