package org.oreon.core.vk.buffers;

import static org.lwjgl.vulkan.VK10.VK_MEMORY_PROPERTY_HOST_COHERENT_BIT;
import static org.lwjgl.vulkan.VK10.VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT;
import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT;

import java.nio.ByteBuffer;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceMemoryProperties;

public class VkUniformBuffer extends VkBuffer{
	
	public VkUniformBuffer(VkDevice device, VkPhysicalDeviceMemoryProperties memoryProperties,
						   ByteBuffer data) {
		
		create(device, data.limit(), VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT);
		allocate(device, memoryProperties,
				 VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);
		mapMemory(device, data);
	}
	
	public void updateData(VkDevice device, ByteBuffer data){
		
		mapMemory(device, data);
	}
}
