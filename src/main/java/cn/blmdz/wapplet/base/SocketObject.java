package cn.blmdz.wapplet.base;

import java.io.Serializable;

import lombok.Data;

/**
 * @author xpoll
 */
@Data
public class SocketObject implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * sendid
	 */
	private Long id;
    
	/**
	 * appletId
	 */
    private Integer applet;
	
	/**
	 * ChatType
	 */
	private Integer type;
	
	/**
	 * toId
	 */
	private Long toId;
	
	/**
	 * data
	 */
	private String data;
}