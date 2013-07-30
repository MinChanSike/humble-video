/*******************************************************************************
 * Copyright (c) 2013, Art Clarke.  All rights reserved.
 *  
 * This file is part of Humble-Video.
 *
 * Humble-Video is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Humble-Video is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Humble-Video.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/

#ifndef __BUFFER_TEST_H__
#define __BUFFER_TEST_H__

#include <io/humble/testutils/TestUtils.h>
#include <io/humble/ferry/RefPointer.h>
#include <io/humble/ferry/Buffer.h>
using namespace VS_CPP_NAMESPACE;

class BufferTest : public CxxTest::TestSuite
{
  public:
    void setUp();
    void tearDown();
    void testCreationAndDestruction();
    void testReadingAndWriting();
    void testWrapping();
  private:
    RefPointer<io::humble::ferry::Buffer> buffer;
    static void freeBuffer(void *buf, void*closure)
    {
      delete [] (unsigned char*)buf;
      if (closure)
        *((bool*)closure) = true;
    }
};


#endif // __BUFFER_TEST_H__

