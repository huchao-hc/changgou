package com.changgou.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Arrays;

/**
 * @author huchao
 * @description: TODO
 * @date 2020/9/18 9:54
 */
@ApiModel(description = "File",value = "File")
@Table(name="tb_File")
public class DBFile {
    @ApiModelProperty(value = "附件id",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ApiModelProperty(value = "附件名称",required = false)
    private String filename;
    @ApiModelProperty(value = "附件后缀",required = false)
    private String fileext;
    @ApiModelProperty(value = "附件内容",required = false)
    private byte[] content;
    @ApiModelProperty(value = "附件创建人",required = false)
    private String createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileext() {
        return fileext;
    }

    public void setFileext(String fileext) {
        this.fileext = fileext;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "DBFile{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", fileext='" + fileext + '\'' +
                ", content=" + Arrays.toString(content) +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}
